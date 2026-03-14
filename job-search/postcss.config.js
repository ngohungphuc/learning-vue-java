import defaultTheme from 'tailwindcss/defaultTheme.js'
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
      colors: {
        'brand-gray-1': '#dadce0',
        'brand-blue-1': '#1967d2',
        'brand-green-1': '#137333',
      },
    },
  },
  content: ['./src/**/*.{vue,js,ts}'],
}
