module.exports = {
  expo: {
    name: "Gurps Companion",
    slug: "gurps-companion",
    privacy: "public",
    platforms: ["ios", "android", "web"],
    version: "1.0.0",
    orientation: "portrait",
    icon: "./assets/icon.png",
    splash: {
      image: "./assets/splash.png",
      resizeMode: "contain",
      backgroundColor: "#fce8a4",
    },
    updates: {
      fallbackToCacheTimeout: 0,
    },
    assetBundlePatterns: ["**/*"],
    ios: {
      supportsTablet: true,
    },
    extra: {
      storybookEnabled: process.env.STORYBOOK_ENABLED,
    },
  },
  plugins: [["expo-router", { root: "./app" }]],
};
