# kdaisyUI

Type-safe [DaisyUI](https://daisyui.com/) components for [kotlinx.html](https://github.com/Kotlin/kotlinx.html).

Write DaisyUI markup in Kotlin with autocompletion, compile-time checks, and zero class-name typos.

![DevTrack — example app built with kdaisyUI](docs/screenshots/overview.png)

```kotlin
createHTML().div {
    daisyCard(extraClasses = "bg-base-100 shadow-xs") {
        daisyCardBody {
            daisyCardTitle("Revenue")
            daisyStats {
                daisyStat {
                    daisyStatValue("21,500 USD")
                    daisyStatDesc("21% more than last month")
                }
            }
            daisyButton("View report", variant = ButtonVariant.Primary)
        }
    }
}
```

## Who is this for?

Kotlin developers building **server-rendered HTML** (with Ktor, Spring, or any JVM framework) who want beautiful, consistent UIs without writing raw CSS class strings.

No frontend build tools required. No JavaScript frameworks. Just Kotlin.

## Documentation

This project follows the [Diátaxis](https://diataxis.fr/) documentation framework:

| | Learn | Work |
|---|---|---|
| **Hands-on** | [Tutorials](docs/tutorials/) — step-by-step lessons | [How-to guides](docs/how-to.md) — solve specific tasks |
| **Theory** | [Explanation](docs/explanation.md) — background concepts | [Reference](docs/reference.md) — complete API |

### Quick links

- **New here?** Start with the [Getting started tutorial](docs/tutorials/getting-started.md)
- **Want to build a real app?** Follow [Build a dashboard with Ktor](docs/tutorials/build-a-dashboard.md)
- **Need a specific recipe?** Check the [How-to guides](docs/how-to.md)
- **Looking up an API?** See the [Component reference](docs/reference.md)

## Quick start

### 1. Add the dependency

No published artifacts yet — use a Gradle composite build:

```kotlin
// settings.gradle.kts
includeBuild("../kdaisyUI")

// build.gradle.kts
dependencies {
    implementation(project(":lib"))
}
```

### 2. Render your first component

```kotlin
import kdaisyui.components.*
import kotlinx.html.div
import kotlinx.html.stream.createHTML

val html = createHTML().div {
    daisyButton("Click me", variant = ButtonVariant.Primary, size = ButtonSize.Lg)
}
// → <div><button class="btn btn-primary btn-lg">Click me</button></div>
```

## Modules

| Module | Description |
|---|---|
| `:lib` | Core library — DSL component wrappers |
| `:example-app` | Ktor + htmx demo dashboard |

## Development environment

### Option A — Dev Container (recommended for new contributors)

Open in any Dev Container-compatible editor (VS Code, IntelliJ, GitHub Codespaces):

```bash
git clone https://github.com/ollin/kdaisyUI
# Open in VS Code → "Reopen in Container"
```

The container provides JDK 21, Gradle 9.3.1, Node 24, and Playwright Chromium pre-installed. Port 8080 is forwarded automatically.

### Option B — Local with asdf

```bash
git clone https://github.com/ollin/kdaisyUI
cd kdaisyUI
asdf install          # reads .tool-versions → JDK 21, Gradle 9.3.1, Node 24
./gradlew :lib:test   # run unit tests
```

### Option C — Any JDK 21+

The Gradle wrapper downloads Gradle automatically. Just bring your own JDK 21+.

## Requirements

| Tool | Version | Purpose |
|---|---|---|
| JDK | **21** (toolchain) | Compile and run |
| Gradle | **9.3.1** (wrapper) | Build system |
| Kotlin | **2.3.10** | Language |
| Node | **24** | E2E tests (Playwright) |

## Run the example

```bash
./gradlew :example-app:run
# → http://localhost:8080
```

## License

MIT. See [LICENSE](LICENSE).

## Acknowledgements

[DaisyUI](https://daisyui.com/) by [Pouya Saadeghi](https://github.com/saadeghi) is the reason this library exists — making Tailwind CSS semantic is genuinely great work. See [CREDITS.md](CREDITS.md) for full acknowledgements of all projects this library builds on.
