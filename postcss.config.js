module.exports = {
  plugins: [
    require("postcss-import"),
    require("tailwindcss"),
    require("autoprefixer"),
    require("nativewind/postcss"),
  ],
};

module.exports = {
  plugins: {
    "nativewind/postcss": {
      output: "nativewind-output.js",
    },
  },
};
