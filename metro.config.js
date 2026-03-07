const { getDefaultConfig } = require("expo/metro-config");

module.exports = (() => {
  const config = getDefaultConfig(__dirname, {
    isCSSEnabled: true,
  });

  return config;
})();
