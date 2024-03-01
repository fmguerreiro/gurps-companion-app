import { AppRegistry } from "react-native";
import App from "./.storybook";
import { expo: { name as appName } } from "./app.config.js";

AppRegistry.registerComponent(appName, () => App);
