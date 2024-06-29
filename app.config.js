module.exports = {
  expo: {
    owner: "tofuman",
    name: "Gurps Companion",
    slug: "gurps-companion-app",
    privacy: "public",
    platforms: ["ios", "android", "web"],
    version: "1.0.0",
    orientation: "portrait",
    icon: "./assets/icon.png",
    splash: {
      image: "./assets/splash.png",
      resizeMode: "contain",
      backgroundColor: "#ffffff",
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
    web: {
      bundler: "metro", // for tailwind support
    },
  },
  plugins: [["expo-router", { root: "./app" }]],
};
