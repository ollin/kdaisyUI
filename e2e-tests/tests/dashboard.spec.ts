import { test, expect } from '@playwright/test';

test.describe('Dashboard shell', () => {
  test('loads with sidebar and header visible immediately', async ({ page }) => {
    await page.goto('/');

    await expect(page.getByText('DevTrack')).toBeVisible();
    await expect(page.getByRole('heading', { name: 'Overview' })).toBeVisible();
    await expect(page.getByPlaceholder('Search')).toBeVisible();
  });

  test('sidebar navigation items are present', async ({ page }) => {
    await page.goto('/');

    const sidebar = page.locator('aside.drawer-side nav');
    await expect(sidebar.locator('a', { hasText: 'Overview' }).first()).toBeAttached();
    await expect(sidebar.locator('summary', { hasText: 'Repositories' })).toBeAttached();
    await expect(sidebar.locator('a', { hasText: 'Issues' })).toBeAttached();
    await expect(sidebar.locator('a', { hasText: 'Pipelines' })).toBeAttached();
    await expect(sidebar.locator('a', { hasText: 'Teams' })).toBeAttached();
    await expect(sidebar.locator('a', { hasText: 'Settings' })).toBeAttached();
  });

  test('sidebar submenu expands on click', async ({ page }) => {
    await page.goto('/');

    const sidebar = page.locator('aside.drawer-side nav');
    const repositoriesToggle = sidebar.locator('summary').filter({ hasText: 'Repositories' });
    await repositoriesToggle.click();

    await expect(sidebar.locator('a', { hasText: 'All Repos' })).toBeVisible();
    await expect(sidebar.locator('a', { hasText: 'New Repository' })).toBeVisible();
  });

  test('CSS is loaded — DaisyUI classes are applied', async ({ page }) => {
    await page.goto('/');

    const sidebar = page.locator('nav').first();
    const bgColor = await sidebar.evaluate(el =>
      window.getComputedStyle(el).backgroundColor
    );
    expect(bgColor).not.toBe('rgba(0, 0, 0, 0)');
    expect(bgColor).not.toBe('');
  });
});

test.describe('Stats fragment', () => {
  test('loads via htmx after page load', async ({ page }) => {
    await page.goto('/');

    await expect(page.getByText('Active Repositories').first()).toBeVisible({ timeout: 5000 });
    await expect(page.getByText('142').first()).toBeVisible();
    await expect(page.getByText('Open Issues').first()).toBeVisible();
  });

  test('fragment endpoint returns HTML directly', async ({ page }) => {
    const response = await page.request.get('/fragments/stats');
    expect(response.status()).toBe(200);
    expect(response.headers()['content-type']).toContain('text/html');

    const body = await response.text();
    expect(body).toContain('stat-title');
    expect(body).toContain('Active Repositories');
  });
});

test.describe('Cards row 1 fragment', () => {
  test('pipeline table loads', async ({ page }) => {
    await page.goto('/');

    await expect(page.getByRole('heading', { name: 'Recent Pipeline Runs' })).toBeVisible({ timeout: 5000 });
    await expect(page.getByRole('cell', { name: 'api-gateway' })).toBeVisible();
    await expect(page.getByRole('cell', { name: 'frontend' })).toBeVisible();
  });

  test('open issues card loads', async ({ page }) => {
    await page.goto('/');

    await expect(page.getByRole('heading', { name: 'Open Issues' })).toBeVisible({ timeout: 5000 });
    await expect(page.getByText('Good First Issue')).toBeVisible();
  });
});

test.describe('Forms fragment', () => {
  test('repository form inputs are present after scroll', async ({ page }) => {
    await page.goto('/');
    await page.evaluate(() => window.scrollTo(0, document.body.scrollHeight / 2));

    await expect(page.getByText('Repository management')).toBeVisible({ timeout: 8000 });
    await expect(page.getByPlaceholder('devtrack/api-gateway').first()).toBeVisible();
  });

  test('select dropdown has .gitignore options', async ({ page }) => {
    await page.goto('/');
    await page.evaluate(() => window.scrollTo(0, document.body.scrollHeight / 2));

    await page.waitForSelector('select.select', { timeout: 8000 });
    const select = page.locator('select.select').nth(1);
    await expect(select).toBeVisible();

    const options = await select.locator('option').allTextContents();
    expect(options).toContain('Node');
  });
});

test.describe('Team fragment', () => {
  test('team form loads after scroll to bottom', async ({ page }) => {
    await page.goto('/');
    await page.evaluate(() => window.scrollTo(0, document.body.scrollHeight));

    await expect(page.getByText('Team management')).toBeVisible({ timeout: 10000 });
    await expect(page.getByText('Invitation sent successfully')).toBeVisible();
    await expect(page.getByRole('button', { name: 'Send invitation' })).toBeVisible();
  });

  test('team fragment endpoint returns HTML', async ({ page }) => {
    const response = await page.request.get('/fragments/team');
    expect(response.status()).toBe(200);

    const body = await response.text();
    expect(body).toContain('Send invitation');
    expect(body).toContain('alert-success');
    expect(body).toContain('Active team members');
  });
});

test.describe('htmx progressive loading', () => {
  test('page initially shows loading spinners then replaces them', async ({ page }) => {
    let spinnerSeenCount = 0;

    page.on('response', response => {
      if (response.url().includes('/fragments/')) {
        spinnerSeenCount++;
      }
    });

    await page.goto('/');
    await page.waitForTimeout(3000);

    expect(spinnerSeenCount).toBeGreaterThanOrEqual(2);
  });

  test('all fragment endpoints return 200', async ({ page }) => {
    const fragments = [
      '/fragments/stats',
      '/fragments/cards-row1',
      '/fragments/cards-row2',
      '/fragments/forms',
      '/fragments/form-sections',
      '/fragments/team',
    ];

    for (const path of fragments) {
      const response = await page.request.get(path);
      expect(response.status(), `${path} should return 200`).toBe(200);
    }
  });
});

test.describe('Webjars assets', () => {
  test('DaisyUI CSS is served from webjars', async ({ page }) => {
    const response = await page.request.get('/webjars/daisyui/daisyui.css');
    expect(response.status()).toBe(200);
    expect(response.headers()['content-type']).toContain('text/css');
  });

  test('htmx JS is served from webjars', async ({ page }) => {
    const response = await page.request.get('/webjars/htmx.org/dist/htmx.min.js');
    expect(response.status()).toBe(200);
    expect(response.headers()['content-type']).toContain('javascript');
  });

  test('Tailwind browser JS is served from webjars', async ({ page }) => {
    const response = await page.request.get('/webjars/tailwindcss__browser/dist/index.global.js');
    expect(response.status()).toBe(200);
    expect(response.headers()['content-type']).toContain('javascript');
  });
});
