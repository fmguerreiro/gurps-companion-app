module.exports = {
  expo: {
    owner: "tofuman",
    name: "Gurps Companion",
    slug: "gurps-companion-app",
    privacy: "public",
    platforms: ["ios", "android", "web"],
    version: "1.0.0",
    orientation: "portrait",
    icon: "./assets/splash.png",
    splash: {
      image: "./assets/splash.png",
      resizeMode: "contain",
      backgroundColor: "#33cfff",
    },
    updates: {
      fallbackToCacheTimeout: 0,
    },
    assetBundlePatterns: ["**/*"],
    ios: {
      supportsTablet: true,
    },
    android: {
      package: "com.fmguerreiro.gurpscompanion",
      versionCode: 1,
    },
    extra: {
      storybookEnabled: process.env.STORYBOOK_ENABLED,
      eas: {
        projectId: process.env.EXPO_PUBLIC_EAS_PROJECT_ID,
      },
    },
    web: {
      bundler: "metro", // for tailwind support
    },
  },
  plugins: [["expo-router", { root: "./app" }]],
};
