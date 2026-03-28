import { defineConfig, devices } from '@playwright/test';

export default defineConfig({
  testDir: './tests',
  fullyParallel: false,
  retries: 1,
  reporter: [['list'], ['html', { open: 'never' }]],
  use: {
    baseURL: 'http://localhost:8080',
    trace: 'on-first-retry',
    screenshot: 'only-on-failure',
  },
  projects: [
    {
      name: 'chromium',
      use: { ...devices['Desktop Chrome'] },
    },
  ],
  // Start the Ktor server before tests, stop after
  webServer: {
    command: 'cd .. && ./gradlew :example-app:run',
    url: 'http://localhost:8080',
    reuseExistingServer: true,
    timeout: 60_000,
  },
});
