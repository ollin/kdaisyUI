# kdaisyui — Claude Code Instructions

> **Read [AGENTS.md](AGENTS.md) first.** It is the single source of truth for this project.

All project conventions, codegen rules, component patterns, anti-patterns, and build commands are documented in [AGENTS.md](AGENTS.md).

## For Library Users

If you're using kdaisyui as a dependency, see [llms.txt](llms.txt) for the API reference.

## Claude-Specific Tips

- Use subagents for complex multi-step tasks (better than one massive context)
- Compact strategically when context grows — don't let quality degrade
- When code generation fails, check if context about the component pattern was missing