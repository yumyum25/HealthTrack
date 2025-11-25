
// playwright.config.js
const { devices } = require('@playwright/test');

module.exports = {
  testDir: './tests',
  projects: [
    {
      name: 'chromium',
      use: { ...devices['Desktop Chrome'] },
    },
  ],
};
