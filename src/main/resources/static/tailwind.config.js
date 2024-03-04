/** @type {import('tailwindcss').Config} */
module.exports = {
  content: [
      "./node_modules/flowbite/**/*.js",
      "./node_modules/tw-elements/js/**/*.js",
      "./../templates/**/*.html",
  ],
  theme: {
    extend: {},
  },
  plugins: [
        require('flowbite/plugin'),
        require("tw-elements/plugin.cjs")
  ],
}

