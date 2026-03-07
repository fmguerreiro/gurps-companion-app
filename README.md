# ClojureScript + React Native Template

A batteries-included template for building mobile apps with ClojureScript. Ships with everything wired up so you can skip the boilerplate and start building.

For a real-world example built on this template, see the [`main` branch](https://github.com/fmguerreiro/gurps-companion-app/tree/main).

## Stack

| Layer | Tech |
|-------|------|
| Language | [ClojureScript](https://clojurescript.org) via [shadow-cljs](https://github.com/thheller/shadow-cljs) |
| Runtime | [React Native](https://reactnative.dev) via [Expo](https://expo.dev) (SDK 51) |
| UI | [Reagent](https://reagent-project.github.io) (React wrapper) |
| State | [re-frame](https://github.com/day8/re-frame) |
| Navigation | [React Navigation](https://reactnavigation.org) (bottom tabs + native stacks) |
| Styling | [twrnc](https://github.com/jaredh159/tailwind-rn) (Tailwind CSS for React Native) |
| Storage | [AsyncStorage](https://react-native-async-storage.github.io/async-storage/) with [transit](https://github.com/cognitect/transit-cljs) serialization |
| i18n | [i18n-js](https://github.com/fnando/i18n) with JSON translation files |
| Dev | nREPL (port 7888) + shadow-cljs hot reload |
| Components | [Storybook](https://storybook.js.org) for React Native |

## Prerequisites

- Node.js 18+
- Java 11+ (for shadow-cljs / ClojureScript compilation)
- iOS Simulator (macOS) or Android emulator
- An editor with nREPL support (Emacs/CIDER, Calva, Cursive)

## Getting started

```bash
# install dependencies
npm install

# terminal 1: start the cljs compiler
npx shadow-cljs server

# terminal 2: start expo
npx expo start
```

shadow-cljs compiles ClojureScript into the `app/` directory. Expo's metro bundler picks it up from there.

Connect your editor's REPL to `localhost:7888` for interactive development.

## How it works

```
                    shadow-cljs
  src/**/*.cljs  ──────────────►  app/index.js  ──►  Metro  ──►  Device/Simulator
                   (compile)                         (bundle)
```

1. You write ClojureScript in `src/`
2. shadow-cljs compiles to JS in `app/`
3. Expo's metro bundler serves the JS to your device
4. Hot reload works automatically — save a file and see changes instantly

## Project structure

```
src/
  app/
    app.cljs                  # entry point, initializes re-frame + i18n
    root.cljs                 # root navigator (bottom tabs)
    db.cljs                   # app-db initial state + specs
    events.cljs               # re-frame event handlers
    subs.cljs                 # re-frame subscriptions
    effects.cljs              # re-frame effect registrations
    pages/
      home.cljs               # example page (counter demo)
    navigation/
      home_stack.cljs          # example native stack navigator
      common.cljs              # shared navigation options
    setup/
      hot_reload.cljs          # dev hot-reload overlay
      i18n_resources.cljs      # translation file loading
    utils/
      i18n.cljs                # i18n helper functions
      helpers.cljs             # general utilities
      debounce.cljs            # debounce/throttle
    widgets/
      base.cljs                # RN component aliases (View, Text, etc.)
      button.cljs              # pressable button
      text.cljs                # text utilities
      dropdown.cljs            # dropdown selector
      underlined_input.cljs    # text input variants
      add_button.cljs          # floating action button
      bracketed_numeric_input.cljs
  react_native/
    async_storage.cljs         # AsyncStorage wrapper with transit
    platform.cljs              # platform detection (ios? android?)
  expo/
    root.cljs                  # Expo root component registration
translations/
  en.json                      # English translation strings
```

## Adding a page

1. Create `src/app/pages/my_page.cljs`:

```clojure
(ns app.pages.my-page
  (:require [app.widgets.base :refer [view text]]
            ["twrnc" :refer [style] :rename {style tw}]))

(defn my-page []
  [:> view {:style (tw "flex-1 items-center justify-center")}
   [:> text {:style (tw "text-xl")} "Hello!"]])
```

2. Create a stack in `src/app/navigation/my_stack.cljs`:

```clojure
(ns app.navigation.my-stack
  (:require ["@react-navigation/native-stack" :as rnn-stack]
            [reagent.core :as r]
            [app.pages.my-page :refer [my-page]]
            [app.navigation.common :refer [options]]))

(defonce Stack (rnn-stack/createNativeStackNavigator))

(defn my-stack []
  (r/with-let [component (fn [props] (r/as-element [my-page props]))]
    [:> Stack.Navigator
     [:> Stack.Screen {:name "MyPage" :component component :options options}]]))
```

3. Add the tab in `src/app/root.cljs`.

## Adding state

Register events in `events.cljs` and subscriptions in `subs.cljs`:

```clojure
;; events.cljs
(rf/reg-event-db :my-feature/do-thing
  (fn [db [_ value]]
    (assoc db :my-feature value)))

;; subs.cljs
(rf/reg-sub :my-feature/value
  (fn [db _] (:my-feature db)))
```

Use in components with `(rf/subscribe [:my-feature/value])` and `(rf/dispatch [:my-feature/do-thing "hello"])`.

## Translations

Add keys to `translations/en.json` and use them with `(i18n/label :t/your-key)`.

## EAS builds

```bash
# preview build (APK for Android)
eas build --profile preview --platform android

# production build
eas build --profile production --platform all
```

Set `EXPO_PUBLIC_EAS_PROJECT_ID` in your environment or `eas.json`.

## License

MIT
