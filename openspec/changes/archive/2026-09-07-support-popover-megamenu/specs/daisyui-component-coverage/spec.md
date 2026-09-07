## ADDED Requirements

### Requirement: Megamenu is constructible as DaisyUI documents it
The library SHALL provide generated wrappers sufficient to build DaisyUI's documented megamenu:
a root carrying the `megamenu` class **and** the `popover` attribute, a mandatory
`megamenu-active` indicator, and one popover panel per item. The panels SHALL be reachable from
the DSL even though they carry no DaisyUI class. None of it SHALL require the caller to set the
`popover` attribute through the raw-attribute escape hatch.

**Verified:** `daisyui/skills/daisyui/components/megamenu.md:16` documents the root as
`<div class="megamenu … {MODIFIER} …" id="my-megamenu-1" popover>`, `:19`-`:22` document each item
as a `popovertarget` button paired with `<div id="item-1" popover>`, and `:62` states that the
`megamenu-active` span is mandatory. Before this change `lib/generated/…/components/Megamenu.kt`
emitted no `popover` attribute anywhere, so the component as generated could not open.

**Verified** (was Assumed; settled by task 1.1): the root's `popover` is unconditional rather
than viewport-dependent. DaisyUI's documented markup was rendered at 1280x800 and 390x844 and the
screenshots reviewed — the root carries `popover` at both, and DaisyUI's own CSS is what makes it
a visible horizontal bar on desktop. Checked in a browser rather than by reading, because
`megamenu.css` is too intricate to settle that way.

**Verified** (found while implementing): `megamenu-active` must be a `<span>`. Not for its own
styling — it is `position: absolute` and styled by class alone — but because
`megamenu.css` selects the open panel with `[popover]:nth-of-type(N)`, and `:nth-of-type` counts
among siblings of the same tag. A `<div>` indicator takes div index 1 and shifts every
`<div popover>` panel by one, anchoring the indicator to the wrong trigger. Measured on
`/megamenu-reference`, which reported `--mm-anchor: --mm2` while panel one was open.

#### Scenario: The documented markup is reachable
- **WHEN** a megamenu is built from the generated wrappers
- **THEN** the root element carries the `megamenu` class and the `popover` attribute
- **AND** each item's panel is a generated wrapper carrying `popover` and its own id
- **AND** no caller supplies `popover` themselves

#### Scenario: A megamenu opens without JavaScript
- **WHEN** the example application serves a megamenu and its `popovertarget` trigger is clicked
  in a browser with JavaScript disabled
- **THEN** the corresponding panel reaches the `:popover-open` state

### Requirement: A construction method is not delivered until a consumer uses it
A generated wrapper for an alternative construction method SHALL be exercised by the example
application and asserted end-to-end before the change that adds it is considered complete.

This is stated as a requirement rather than left as practice because the failure it prevents has
now occurred twice. A construction method that introduces no new CSS class is invisible to the
generated tests, which assert class strings; to `generated-sources-drift`, which compares the
generator's output against itself; and to the coverage gate, which cannot miss code that was
never generated. A consumer is the only check that fails.

**Verified:** `modal`'s popover method was recorded as delivered by the archived
`adapt-daisyui-5-6` while nothing implemented it, and `megamenu` carried the same defect until
this change — the example app rendered it and the E2E asserted it, both passing, because both
only looked at classes.

This change produced a third instance of the same blind spot, which is why the requirement is
worth its weight: turning `megamenu-active` into a `<span>` changed no class, and so was invisible
to the generated tests, to `generated-sources-drift`, **and** to `api-baseline` — the last because
`(DIV.() -> Unit)` and `(SPAN.() -> Unit)` both erase to `Function1`. Only an end-to-end
assertion that measured the rendered page caught it.

#### Scenario: Absence is detected by a consumer
- **WHEN** a component gains a construction method that adds no new CSS class
- **THEN** an example-app route uses it
- **AND** an end-to-end assertion covers the attribute that defines it, not only its classes
