import { defineConfig, globalIgnores } from 'eslint/config'
import globals from 'globals'
import js from '@eslint/js'
import pluginVue from 'eslint-plugin-vue'
import pluginVitest from '@vitest/eslint-plugin'
import pluginOxlint from 'eslint-plugin-oxlint'
import skipFormatting from 'eslint-config-prettier/flat'
import tseslint from 'typescript-eslint' // Needed for the TS config

export default defineConfig([
  {
    name: 'app/files-to-lint',
    files: ['**/*.{ts,mts,vue,js,mjs,jsx}'], // Added ts/mts
  },

  globalIgnores(['**/dist/**', '**/dist-ssr/**', '**/coverage/**']),

  // 1. Replaces @vue/eslint-config-typescript from your screenshot
  ...tseslint.configs.recommended,

  // 2. Replaces eslint:recommended
  js.configs.recommended,

  // 3. Replaces plugin:vue/vue3-recommended (Stronger than 'essential')
  ...pluginVue.configs['flat/recommended'],

  {
    languageOptions: {
      globals: {
        ...globals.browser,
        ...globals.node,
      },
    },
  },

  {
    // 4. Replaces plugin:vitest-globals/recommended
    ...pluginVitest.configs.recommended,
    files: ['src/**/__tests__/*'],
    languageOptions: {
      globals: {
        ...pluginVitest.environments.env.globals,
      },
    },
  },

  ...pluginOxlint.buildFromOxlintConfigFile('.oxlintrc.json'),

  // 5. Replaces @vue/eslint-config-prettier
  skipFormatting,
])
