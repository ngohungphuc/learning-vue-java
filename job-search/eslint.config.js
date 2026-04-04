import { defineConfig, globalIgnores } from 'eslint/config'
import globals from 'globals'
import js from '@eslint/js'
import pluginVue from 'eslint-plugin-vue'
import pluginVitest from '@vitest/eslint-plugin'
import pluginOxlint from 'eslint-plugin-oxlint'
import skipFormatting from 'eslint-config-prettier/flat'
import tseslint from 'typescript-eslint'

export default defineConfig([
  {
    name: 'app/files-to-lint',
    files: ['**/*.{ts,mts,vue,js,mjs,jsx}'],
  },

  globalIgnores(['**/dist/**', '**/dist-ssr/**', '**/coverage/**']),

  ...tseslint.configs.recommended,
  js.configs.recommended,
  ...pluginVue.configs['flat/recommended'],

  {
    languageOptions: {
      globals: {
        ...globals.browser,
        ...globals.node,
      },
    },
  },

  // FIXED SECTION FOR VITEST
  {
    files: ['**/__tests__/**'], // Use double asterisks to catch subfolders like /api/
    plugins: {
      vitest: pluginVitest,
    },
    languageOptions: {
      globals: {
        ...pluginVitest.environments.env.globals, // This adds describe, beforeEach, etc.
      },
    },
    rules: {
      ...pluginVitest.configs.recommended.rules,
    },
  },

  ...pluginOxlint.buildFromOxlintConfigFile('.oxlintrc.json'),
  skipFormatting,
])
