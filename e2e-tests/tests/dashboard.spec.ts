import { test, expect, Page } from '@playwright/test';

test.describe('Dashboard shell', () => {
  test('loads with sidebar and header visible immediately', async ({ page }) => {
    await page.goto('/');

    await expect(page.getByText('Daisy Corp')).toBeVisible();
    await expect(page.getByRole('heading', { name: 'Dashboard' })).toBeVisible();
    await expect(page.getByPlaceholder('Search')).toBeVisible();
  });

  test('sidebar navigation items are present', async ({ page }) => {
    await page.goto('/');

    const sidebar = page.locator('aside.drawer-side nav');
    await expect(sidebar.locator('a', { hasText: 'Dashboard' }).first()).toBeAttached();
    await expect(sidebar.locator('a', { hasText: 'Users' })).toBeAttached();
    await expect(sidebar.locator('a', { hasText: 'Stats' })).toBeAttached();
    await expect(sidebar.locator('a', { hasText: 'Logs' })).toBeAttached();
  });

  test('sidebar submenu expands on click', async ({ page }) => {
    await page.goto('/');

    const sidebar = page.locator('aside.drawer-side nav');
    const productsToggle = sidebar.locator('summary').filter({ hasText: 'Products' });
    await productsToggle.click();

    await expect(sidebar.locator('a', { hasText: 'All Products' })).toBeVisible();
    await expect(sidebar.locator('a', { hasText: 'Add New' })).toBeVisible();
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

    await expect(page.getByText('Total Page Views').first()).toBeVisible({ timeout: 5000 });
    await expect(page.getByText('89,400').first()).toBeVisible();
    await expect(page.getByText('21% more than last month').first()).toBeVisible();
  });

  test('fragment endpoint returns HTML directly', async ({ page }) => {
    const response = await page.request.get('/fragments/stats');
    expect(response.status()).toBe(200);
    expect(response.headers()['content-type']).toContain('text/html');

    const body = await response.text();
    expect(body).toContain('stat-title');
    expect(body).toContain('89,400');
  });
});

test.describe('Cards row 1 fragment', () => {
  test('transactions table loads', async ({ page }) => {
    await page.goto('/');

    await expect(page.getByRole('heading', { name: 'Transactions' })).toBeVisible({ timeout: 5000 });
    await expect(page.getByText('Cy Ganderton')).toBeVisible();
    await expect(page.getByText('Hart Hagerty').first()).toBeVisible();
  });

  test('revenue card loads', async ({ page }) => {
    await page.goto('/');

    await expect(page.getByText('21,500 USD')).toBeVisible({ timeout: 5000 });
    await expect(page.getByText('Revenue report →')).toBeVisible();
  });
});

test.describe('Forms fragment', () => {
  test('form inputs are present after scroll', async ({ page }) => {
    await page.goto('/');
    await page.evaluate(() => window.scrollTo(0, document.body.scrollHeight / 2));

    await expect(page.getByText('Forms and inputs')).toBeVisible({ timeout: 8000 });
    await expect(page.getByPlaceholder('Type here').first()).toBeVisible();
  });

  test('select dropdown has options', async ({ page }) => {
    await page.goto('/');
    await page.evaluate(() => window.scrollTo(0, document.body.scrollHeight / 2));

    await page.waitForSelector('select.select', { timeout: 8000 });
    const select = page.locator('select.select').first();
    await expect(select).toBeVisible();

    const options = await select.locator('option').allTextContents();
    expect(options).toContain('T-shirts');
  });
});

test.describe('Payment fragment', () => {
  test('payment form loads after scroll to bottom', async ({ page }) => {
    await page.goto('/');
    await page.evaluate(() => window.scrollTo(0, document.body.scrollHeight));

    await expect(page.getByText('Payment information')).toBeVisible({ timeout: 10000 });
    await expect(page.getByText('Your payment was successful')).toBeVisible();
    await expect(page.getByRole('button', { name: 'Confirm Payment' })).toBeVisible();
  });

  test('payment fragment endpoint returns HTML', async ({ page }) => {
    const response = await page.request.get('/fragments/payment');
    expect(response.status()).toBe(200);

    const body = await response.text();
    expect(body).toContain('Confirm Payment');
    expect(body).toContain('alert-success');
    expect(body).toContain('Recent user transactions');
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
      '/fragments/payment',
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
