const defaultTheme = require('tailwindcss/defaultTheme')
export default {
  plugins: {
    '@tailwindcss/postcss': {},
    autoprefixer: {},
  },
  theme: {
    extend: {
      fontFamily: {
        sans: ['Open Sans', ...defaultTheme.fontFamily.sans],
      },
    },
  },
  content: ['./src/**/*.{vue,js,ts}'],
}
