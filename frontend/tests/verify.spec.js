
const { test, expect } = require('@playwright/test');

test.describe('Mi Perfil Page', () => {
  test('should load the page and display the main content', async ({ page }) => {
    // Navigate to the local server
    await page.goto('http://localhost:8000/miperfil.html');

    // Check that the main title is visible
    await expect(page.locator('h1')).toHaveText('Mi Perfil');

    // Check that the footer is visible
    await expect(page.locator('footer .footer-content')).toBeVisible();

    // Take a screenshot for visual verification
    await page.screenshot({ path: '/home/jules/verification/verification.png' });
  });
});
