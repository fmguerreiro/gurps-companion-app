const path = require("path");
const { getDefaultConfig } = require("expo/metro-config");

module.exports = (() => {
  const config = getDefaultConfig(__dirname, {
    isCSSEnabled: true,
  });

  config.resolver.extraNodeModules = {
    "storybook-bridge": path.resolve(__dirname, "storybook-bridge.js"),
  };

  return config;
})();
