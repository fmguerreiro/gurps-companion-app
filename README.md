<p align="center">
  <img src="https://raw.githubusercontent.com/PKief/vscode-material-icon-theme/ec559a9f6bfd399b82bb44393651661b08aaf7ba/icons/folder-markdown-open.svg" width="100" alt="project-logo">
</p>
<p align="center">
    <h1 align="center">GURPS-COMPANION-APP</h1>
</p>
<p align="center">
    <em>Crafting immersive worlds, one feature at a time.</em>
</p>
<p align="center">
	<img src="https://img.shields.io/github/license/fmguerreiro/gurps-companion-app?style=default&logo=opensourceinitiative&logoColor=white&color=0080ff" alt="license">
	<img src="https://img.shields.io/github/last-commit/fmguerreiro/gurps-companion-app?style=default&logo=git&logoColor=white&color=0080ff" alt="last-commit">
	<img src="https://img.shields.io/github/languages/top/fmguerreiro/gurps-companion-app?style=default&color=0080ff" alt="repo-top-language">
	<img src="https://img.shields.io/github/languages/count/fmguerreiro/gurps-companion-app?style=default&color=0080ff" alt="repo-language-count">
<p>
<p align="center">
	<!-- default option, no dependency badges. -->
</p>

<br><!-- TABLE OF CONTENTS -->
<details>
  <summary>Table of Contents</summary><br>

- [ Overview](#-overview)
- [ Features](#-features)
- [ Repository Structure](#-repository-structure)
- [ Modules](#-modules)
- [ Getting Started](#-getting-started)
  - [ Installation](#-installation)
  - [ Usage](#-usage)
  - [ Tests](#-tests)
- [ Project Roadmap](#-project-roadmap)
- [ Contributing](#-contributing)
- [ License](#-license)
- [ Acknowledgments](#-acknowledgments)
</details>
<hr>

##  Overview

The gurps-companion-app is a comprehensive mobile application supporting GURPS 4th edition, offering character management functionalities such as skill tracking, item management, and character attribute handling. With dynamic internationalization features and intuitive navigation structures, this app provides a seamless experience for users to organize and interact with their in-game characters efficiently. Through its structured layout and real-time data updates, the app enhances gameplay dynamics and fosters engaging role-playing experiences for GURPS enthusiasts.

---

##  Features

|    |   Feature         | Description |
|----|-------------------|---------------------------------------------------------------|
| ⚙️  | **Architecture**  | Built using React Native with a focus on modularity and code reusability. Utilizes Expo for simplified development and deployment. Storybook is used for component development and testing. |
| 🔩 | **Code Quality**  | Follows modern JavaScript best practices and code standards. Utilizes Tailwind CSS for consistent styling. Codebase is organized with clear separation of concerns. |
| 📄 | **Documentation** | Contains detailed documentation for project setup, configuration, and usage. Includes guides for developers on contributing and extending the application. |
| 🔌 | **Integrations**  | Integrates with various React Native libraries like react-native-tab-view, react-native-slider, and react-navigation for navigation. Also integrates with Expo libraries for features like expo-image-picker. |
| 🧩 | **Modularity**    | Codebase is structured in a modular way, making it easy to extend and maintain. Components are reusable and well encapsulated. Follows a component-driven development approach. |
| 🧪 | **Testing**       | Utilizes Storybook for component testing and development. Supports unit testing with Jest for React Native components. |
| ⚡️  | **Performance**   | Optimized for efficiency, fast rendering, and smooth user experience. Utilizes React Native's performance optimizations and Expo's build optimizations for production. |
| 🛡️ | **Security**      | Follows best practices for data protection and access control within the application. Integrates Expo's security features for secure app development. |
| 📦 | **Dependencies**  | Leverages a variety of external libraries and dependencies such as react-native, react-navigation, Expo packages, and Tailwind CSS for styling. |
| 🚀 | **Scalability**   | Designed with scalability in mind, capable of handling increased traffic and load. Utilizes React Native's scalability features and Expo's resources for app scalability. |

These insights are based on the project's dependencies and repository contents provided.

---

##  Repository Structure

```sh
└── gurps-companion-app/
    ├── .github
    │   └── FUNDING.yml
    ├── README.md
    ├── app.config.js
    ├── assets
    │   ├── cljs.png
    │   ├── icon.png
    │   ├── shadow-cljs.png
    │   └── splash.png
    ├── babel.config.js
    ├── eas-build-pre-install.sh
    ├── etc
    │   ├── metro-bundler.patch
    │   └── toolchain-report
    ├── externs
    │   └── app.txt
    ├── index.js
    ├── package-lock.json
    ├── package.json
    ├── rn-rf-shadow.png
    ├── shadow-cljs.edn
    ├── src
    │   ├── css
    │   ├── expo
    │   ├── gurps
    │   └── react_native
    ├── storybook.js
    ├── tailwind.config.js
    └── translations
        └── en.json
```

---

##  Modules

<details closed><summary>.</summary>

| File                                                                                                                | Summary                                                                                                                                                                                                                                                                                                                                                                                                                                                             |
| ---                                                                                                                 | ---                                                                                                                                                                                                                                                                                                                                                                                                                                                                 |
| [storybook.js](https://github.com/fmguerreiro/gurps-companion-app/blob/master/storybook.js)                         | Registers the Storybook app component using React Natives AppRegistry based on the Expo app name defined in app.config.js.                                                                                                                                                                                                                                                                                                                                          |
| [shadow-cljs.edn](https://github.com/fmguerreiro/gurps-companion-app/blob/master/shadow-cljs.edn)                   | Defines build configurations for React Native and storybook, specifying dependencies and compiler options, enabling hot-reload and repl for development. Organizes source paths and middleware settings for optimal project structure and performance.                                                                                                                                                                                                              |
| [tailwind.config.js](https://github.com/fmguerreiro/gurps-companion-app/blob/master/tailwind.config.js)             | Defines Tailwind CSS configuration to style components in app/ folder based on specified theme extensions.                                                                                                                                                                                                                                                                                                                                                          |
| [eas-build-pre-install.sh](https://github.com/fmguerreiro/gurps-companion-app/blob/master/eas-build-pre-install.sh) | Ensure successful macOS shadow-cljs build by installing Java via Homebrew JDK 11, creating a symbolic link, and updating PATH in the script for the parent repository architecture.                                                                                                                                                                                                                                                                                 |
| [app.config.js](https://github.com/fmguerreiro/gurps-companion-app/blob/master/app.config.js)                       | Defines configuration settings for the Expo app, including platform support, versioning, and additional features. Controls app name, privacy, icons, and splash screen appearances, while enabling Storybook and specifying bundler for web compatibility.                                                                                                                                                                                                          |
| [index.js](https://github.com/fmguerreiro/gurps-companion-app/blob/master/index.js)                                 | Imports the main index.js file from the app directory, crucial for initializing the apps core functionality within the repositorys architecture.                                                                                                                                                                                                                                                                                                                    |
| [babel.config.js](https://github.com/fmguerreiro/gurps-companion-app/blob/master/babel.config.js)                   | Configures Babel presets for Expo in the projects architecture. Caches and returns preset setup for seamless Expo development.                                                                                                                                                                                                                                                                                                                                      |
| [package-lock.json](https://github.com/fmguerreiro/gurps-companion-app/blob/master/package-lock.json)               | The code file in question plays a crucial role in the Gurps Companion App repository by managing the configuration settings for the application. It helps ensure that the app functions smoothly by defining various essential parameters without delving into technical specifics. This file acts as a central hub for specifying how the app should behave and interact with its environment, ultimately contributing to the overall architecture of the project. |
| [package.json](https://github.com/fmguerreiro/gurps-companion-app/blob/master/package.json)                         | Defines project scripts for server, Expo, Storybook, CSS watch, Android, iOS, web, release builds, eject, and EAS build tasks. Lists dependencies like React Native, Expo, and Storybook. Configures development tools for streamlined app development in the repository.                                                                                                                                                                                           |

</details>

<details closed><summary>externs</summary>

| File                                                                                      | Summary                                                                                                                                                                                                                                                                             |
| ---                                                                                       | ---                                                                                                                                                                                                                                                                                 |
| [app.txt](https://github.com/fmguerreiro/gurps-companion-app/blob/master/externs/app.txt) | Defines missing type hints for specific React concepts, aiding in building React apps with Fulcro. Abstraction allows seamless integration without processing JavaScript. Crucial for maintaining clarity in app development using Fulcro framework within this repos architecture. |

</details>

<details closed><summary>etc</summary>

| File                                                                                                          | Summary                                                                                                                                              |
| ---                                                                                                           | ---                                                                                                                                                  |
| [toolchain-report](https://github.com/fmguerreiro/gurps-companion-app/blob/master/etc/toolchain-report)       | Generates version reports for defined toolchain packages. Queries tools for versions using regex patterns. Outputs key-value pairs of tool versions. |
| [metro-bundler.patch](https://github.com/fmguerreiro/gurps-companion-app/blob/master/etc/metro-bundler.patch) | Improves Metro bundler performance by optimizing plugins. Enhances project build speed by revising plugin usage in the Metro bundler configuration.  |

</details>

<details closed><summary>.github</summary>

| File                                                                                              | Summary                                                                                                                                                                      |
| ---                                                                                               | ---                                                                                                                                                                          |
| [FUNDING.yml](https://github.com/fmguerreiro/gurps-companion-app/blob/master/.github/FUNDING.yml) | Facilitates funding options for the repository with supported platforms like GitHub and PEZ. Enhances project sustainability and support through various sponsorship models. |

</details>

<details closed><summary>translations</summary>

| File                                                                                           | Summary                                                                                                                                                                                                                                                                                                                                                                                                                                                    |
| ---                                                                                            | ---                                                                                                                                                                                                                                                                                                                                                                                                                                                        |
| [en.json](https://github.com/fmguerreiro/gurps-companion-app/blob/master/translations/en.json) | The `translations/en.json` file in the `gurps-companion-app` repository defines key user interface text strings for the GURPS companion apps 4th edition. It includes essential headings and labels related to stats, items, armor, and combat mechanics, ensuring a consistent and localized user experience across the application. This file plays a crucial role in facilitating seamless navigation and comprehension within the GURPS companion app. |

</details>

<details closed><summary>src.css</summary>

| File                                                                                                | Summary                                                                                                                                                                                               |
| ---                                                                                                 | ---                                                                                                                                                                                                   |
| [tailwind.css](https://github.com/fmguerreiro/gurps-companion-app/blob/master/src/css/tailwind.css) | Implements Tailwind CSS configuration to provide consistent styling across components in the app. Integrates base styles, components, and utility classes for streamlined and cohesive design system. |

</details>

<details closed><summary>src.gurps</summary>

| File                                                                                                  | Summary                                                                                                                                                                                                                                                                                 |
| ---                                                                                                   | ---                                                                                                                                                                                                                                                                                     |
| [effects.cljs](https://github.com/fmguerreiro/gurps-companion-app/blob/master/src/gurps/effects.cljs) | Integrates asynchronous storage effects and common effects for GURPS, enhancing gameplay experience in the app.                                                                                                                                                                         |
| [subs.cljs](https://github.com/fmguerreiro/gurps-companion-app/blob/master/src/gurps/subs.cljs)       | Defines re-frame subscriptions for checking if app is initialized and accessing navigation root state in the Gurps Companion app, contributing to a clear separation of concerns within the overarching architecture.                                                                   |
| [db.cljs](https://github.com/fmguerreiro/gurps-companion-app/blob/master/src/gurps/db.cljs)           | Defines database schema with character attributes, skills, and initial state. Maintains app state for a role-playing companion app. Focuses on data modeling and structure for character management.                                                                                    |
| [app.cljs](https://github.com/fmguerreiro/gurps-companion-app/blob/master/src/gurps/app.cljs)         | Defines app setup, language loading, and root rendering. Manages i18n, async storage, events, and effects. Conditionally enables Storybook. Syncs DB, initializes storage, and hides splash screen. Facilitates a seamless start in the Gurps Companion App.                            |
| [events.cljs](https://github.com/fmguerreiro/gurps-companion-app/blob/master/src/gurps/events.cljs)   | Implements event handling and database initialization for the gurps companion app, including spec validation and async storage setup.                                                                                                                                                   |
| [root.cljs](https://github.com/fmguerreiro/gurps-companion-app/blob/master/src/gurps/root.cljs)       | Defines navigation structure & visual elements for the GURPS Companion app. Creates a tab layout with icons and titles, linking to character stats, skills, items, and info pages. Implements safe area handling and state persistence for seamless user experience during development. |

</details>

<details closed><summary>src.gurps.setup</summary>

| File                                                                                                                      | Summary                                                                                                                                                                                                                    |
| ---                                                                                                                       | ---                                                                                                                                                                                                                        |
| [hot_reload.cljs](https://github.com/fmguerreiro/gurps-companion-app/blob/master/src/gurps/setup/hot_reload.cljs)         | Enables triggering UI and code reloads, handles build status notifications in the app.                                                                                                                                     |
| [i18n_resources.cljs](https://github.com/fmguerreiro/gurps-companion-app/blob/master/src/gurps/setup/i18n_resources.cljs) | Implements internationalization setup for the app, allowing for multiple languages to be loaded dynamically. Loads and manages translations based on users selected language, enhancing user experience and accessibility. |

</details>

<details closed><summary>src.gurps.navigation</summary>

| File                                                                                                                       | Summary                                                                                                                                                                                                                                                              |
| ---                                                                                                                        | ---                                                                                                                                                                                                                                                                  |
| [view.cljs](https://github.com/fmguerreiro/gurps-companion-app/blob/master/src/gurps/navigation/view.cljs)                 | Enables dynamic rendering of navigation screens with configurable themes, safe area handling, and optional bottom sheet display. Seamless integration with alert banners and toasts components for a consistent user interface experience.                           |
| [effects.cljs](https://github.com/fmguerreiro/gurps-companion-app/blob/master/src/gurps/navigation/effects.cljs)           | Manages navigation effects to interact with the apps root, stack, and modals. Enables actions like setting root, navigating, dismissing modals, and showing overlays like toasts and bottom sheets. Controls app flow through a structured, user-friendly interface. |
| [skills_stack.cljs](https://github.com/fmguerreiro/gurps-companion-app/blob/master/src/gurps/navigation/skills_stack.cljs) | Implements a stack navigator for navigating between different skill-related screens in the Gurps Companion app. Handles rendering of screens for viewing character skills, adding new skills, and specifying skill specializations.                                  |
| [items_stack.cljs](https://github.com/fmguerreiro/gurps-companion-app/blob/master/src/gurps/navigation/items_stack.cljs)   | Defines a tab navigation stack for items, melee weapons, and ranged weapons within the app. Renders screens based on user selections, enhancing the overall user experience in navigating character items effectively.                                               |

</details>

<details closed><summary>src.gurps.utils</summary>

| File                                                                                                          | Summary                                                                                                                                                                                                                                                                                    |
| ---                                                                                                           | ---                                                                                                                                                                                                                                                                                        |
| [i18n.cljs](https://github.com/fmguerreiro/gurps-companion-app/blob/master/src/gurps/utils/i18n.cljs)         | Implements internationalization setup and utilities for translations in the app using i18n-js. Manages localization settings, number formatting, and label translations. Provides functions for setting language, formatting numbers, handling pluralization, and retrieving translations. |
| [debounce.cljs](https://github.com/fmguerreiro/gurps-companion-app/blob/master/src/gurps/utils/debounce.cljs) | Implements debounce and throttle functions to manage event dispatching in the app, preventing multiple rapid triggers. Maintains state with atoms and leverages setTimeout for event handling. Key features include clearing timeouts, debouncing dispatches, and throttling event calls.  |
| [helpers.cljs](https://github.com/fmguerreiro/gurps-companion-app/blob/master/src/gurps/utils/helpers.cljs)   | Implements helper functions for handling default values, integer conversion, keyword and string transformations, and flattening keys in the context of the parent repositorys architecture for the GURPS Companion App project.                                                            |

</details>

<details closed><summary>src.gurps.common</summary>

| File                                                                                                         | Summary                                                                                                           |
| ---                                                                                                          | ---                                                                                                               |
| [effects.cljs](https://github.com/fmguerreiro/gurps-companion-app/blob/master/src/gurps/common/effects.cljs) | Implements event chain effects for state management using re-frame, logging each effect dispatched for debugging. |

</details>

<details closed><summary>src.gurps.common.async_storage</summary>

| File                                                                                                                       | Summary                                                                                                                                                                                                                 |
| ---                                                                                                                        | ---                                                                                                                                                                                                                     |
| [effects.cljs](https://github.com/fmguerreiro/gurps-companion-app/blob/master/src/gurps/common/async_storage/effects.cljs) | Defines re-frame effects for asynchronous storage operations using React Natives async-storage library in gurps-companion-apps architecture. Includes functions for setting single/multiple values and retrieving data. |

</details>

<details closed><summary>src.gurps.events</summary>

| File                                                                                                         | Summary                                                                                                                                                                            |
| ---                                                                                                          | ---                                                                                                                                                                                |
| [profile.clj](https://github.com/fmguerreiro/gurps-companion-app/blob/master/src/gurps/events/profile.clj)   | Generates a profile subscription with specified parameters using Re-Frame in the events namespace of the Gurps Companion App, enhancing state management for profile-related data. |
| [profile.cljs](https://github.com/fmguerreiro/gurps-companion-app/blob/master/src/gurps/events/profile.cljs) | Defines re-frame events and subscriptions for managing player profiles in the app. Updates and fetches profile data while utilizing asynchronous storage operations as required.   |

</details>

<details closed><summary>src.gurps.pages.character</summary>

| File                                                                                                                | Summary                                                                                                                                                                                                                                                                  |
| ---                                                                                                                 | ---                                                                                                                                                                                                                                                                      |
| [items.cljs](https://github.com/fmguerreiro/gurps-companion-app/blob/master/src/gurps/pages/character/items.cljs)   | Defines item components for a characters possessions, including name, location, weight, and damage reduction. Facilitates item management with interactive input fields and dropdowns. Maintains state updates using re-frame for a cohesive user experience in the app. |
| [stats.cljs](https://github.com/fmguerreiro/gurps-companion-app/blob/master/src/gurps/pages/character/stats.cljs)   | Defines the character stats page layout by incorporating summary, attributes, bases table, and encumbrance table components within a ScrollView, styled with predefined attributes for a visually appealing user interface.                                              |
| [skills.cljs](https://github.com/fmguerreiro/gurps-companion-app/blob/master/src/gurps/pages/character/skills.cljs) | Defines UI elements, logic for character skills page. Handles skill display, attributes, levels, and costs dynamically. Registers subs for skills and updates. Manages skill cost changes and async storage.                                                             |
| [info.cljs](https://github.com/fmguerreiro/gurps-companion-app/blob/master/src/gurps/pages/character/info.cljs)     | Defines character information layout with summary, portrait, tech level dropdown, reaction modifiers, languages, and notes sections in a white-themed view.                                                                                                              |

</details>

<details closed><summary>src.gurps.pages.character.utils</summary>

| File                                                                                                                                  | Summary                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                           |
| ---                                                                                                                                   | ---                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                               |
| [damage_table.cljs](https://github.com/fmguerreiro/gurps-companion-app/blob/master/src/gurps/pages/character/utils/damage_table.cljs) | Defines damage thresholds for GURPS character combat, simplifying rule lookup.                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                    |
| [skills.cljs](https://github.com/fmguerreiro/gurps-companion-app/blob/master/src/gurps/pages/character/utils/skills.cljs)             | The `skills.cljs` file within the `gurps-companion-app` repository's architecture serves a critical role in managing and processing character-related skills in the GURPS Companion application. This file encapsulates essential utility functions and logic necessary for handling skills within character pages. It contributes to the functionality that enables users to interact with and manage skills associated with their in-app characters, enhancing the overall user experience and gameplay dynamics.By leveraging the capabilities defined in `skills.cljs`, the GURPS Companion app can effectively organize, track, and display character skills, offering users a seamless and intuitive interface to engage with their characters abilities. This component plays a pivotal part in ensuring the application's robust feature set related to character development and progression in the GURPS gaming system. |

</details>

<details closed><summary>src.gurps.pages.character.info.widgets</summary>

| File                                                                                                                                                                     | Summary                                                                                                                                                                                                                                                                                   |
| ---                                                                                                                                                                      | ---                                                                                                                                                                                                                                                                                       |
| [languages_section.cljs](https://github.com/fmguerreiro/gurps-companion-app/blob/master/src/gurps/pages/character/info/widgets/languages_section.cljs)                   | Implements language selection section with dynamic cost calculation for character profiles in the GURPS Companion App. It uses dropdowns, buttons, and inputs to manage spoken and written skills with corresponding costs. The section updates and displays languages as users interact. |
| [reaction_modifiers_section.cljs](https://github.com/fmguerreiro/gurps-companion-app/blob/master/src/gurps/pages/character/info/widgets/reaction_modifiers_section.cljs) | Defines functions for character appearances, status, and reputation inputs. Registers a reaction modifiers section component. Subscribes to profile data and updates state asynchronously. Organized under gurps/pages/character/info/widgets directory in the React Native app.          |
| [tech_level_dropdown.cljs](https://github.com/fmguerreiro/gurps-companion-app/blob/master/src/gurps/pages/character/info/widgets/tech_level_dropdown.cljs)               | Defines dropdown options for technology levels with associated labels and descriptions. Implements selection handling and updates in Re-frame subscription and event effects via asynchronous storage.                                                                                    |
| [notes.cljs](https://github.com/fmguerreiro/gurps-companion-app/blob/master/src/gurps/pages/character/info/widgets/notes.cljs)                                           | Implements notes section for character profiles with real-time editing and AsyncStorage updates.                                                                                                                                                                                          |
| [portrait.cljs](https://github.com/fmguerreiro/gurps-companion-app/blob/master/src/gurps/pages/character/info/widgets/portrait.cljs)                                     | Enables selecting and updating user profile portraits. Requests media library permissions, launches image library, and dispatches selected image URI for profile update.                                                                                                                  |

</details>

<details closed><summary>src.gurps.pages.character.skills</summary>

| File                                                                                                                                       | Summary                                                                                                                                                                                                                                                     |
| ---                                                                                                                                        | ---                                                                                                                                                                                                                                                         |
| [specialization.cljs](https://github.com/fmguerreiro/gurps-companion-app/blob/master/src/gurps/pages/character/skills/specialization.cljs) | Defines functions to display skill details, including specializations, dependencies, and functionality to add skills with associated costs. Interacts with the user interface for skill management within the GURPS companion app.                          |
| [groups.cljs](https://github.com/fmguerreiro/gurps-companion-app/blob/master/src/gurps/pages/character/skills/groups.cljs)                 | Displays a categorized list of game skills as interactive buttons. Users can click on skills to view details and add them to a character. Skills are grouped by category, with each button linked to skill information and character customization options. |

</details>

<details closed><summary>src.gurps.pages.character.items</summary>

| File                                                                                                                                                | Summary                                                                                                                                                                                                                                                         |
| ---                                                                                                                                                 | ---                                                                                                                                                                                                                                                             |
| [defenses_section.cljs](https://github.com/fmguerreiro/gurps-companion-app/blob/master/src/gurps/pages/character/items/defenses_section.cljs)       | Implements labeled defense sections with dynamic values for DR, parry, and block calculations. Subscriptions to item data and skill levels govern display values. Achieves coherent UI presentation for character defense details within the apps architecture. |
| [ranged_weapons_page.cljs](https://github.com/fmguerreiro/gurps-companion-app/blob/master/src/gurps/pages/character/items/ranged_weapons_page.cljs) | Defines a page for managing ranged weapons in the GURPS Companion app. Displays weapon details like damage and range in a structured layout. Supports editing and updating weapon information, synchronizing changes with app state.                            |
| [melee_weapons_page.cljs](https://github.com/fmguerreiro/gurps-companion-app/blob/master/src/gurps/pages/character/items/melee_weapons_page.cljs)   | Implements a dynamic page for managing melee weapons, displaying essential details and enabling real-time updates. Utilizes structured layouts and interactive components to enhance user experience in the character management section of the application.    |

</details>

<details closed><summary>src.gurps.pages.character.widgets</summary>

| File                                                                                                                                                                  | Summary                                                                                                                                                                                                                                                                       |
| ---                                                                                                                                                                   | ---                                                                                                                                                                                                                                                                           |
| [bases_table.cljs](https://github.com/fmguerreiro/gurps-companion-app/blob/master/src/gurps/pages/character/widgets/bases_table.cljs)                                 | Enhances character attributes functionality with dynamic tables in the GURPS Companion app. Manages attribute costs updates and calculations for basic speed and damage, supporting a seamless user experience.                                                               |
| [summary.cljs](https://github.com/fmguerreiro/gurps-companion-app/blob/master/src/gurps/pages/character/widgets/summary.cljs)                                         | Defines summary widgets for character attributes with styling. Organizes fields in groups for name, player, point totals, physical attributes, and more. Designed for view rendering and easily scalable within the parent repositorys architecture.                          |
| [reified_attribute.cljs](https://github.com/fmguerreiro/gurps-companion-app/blob/master/src/gurps/pages/character/widgets/reified_attribute.cljs)                     | Calculates and updates attribute costs in character creation. Utilizes re-frame state management for real-time attribute value changes. Integrated within the GURPS companion apps architecture.                                                                              |
| [point_total.cljs](https://github.com/fmguerreiro/gurps-companion-app/blob/master/src/gurps/pages/character/widgets/point_total.cljs)                                 | Calculates and displays total character points and unspent points in the GURPS Companion App. Utilizes re-frame for state management, allowing real-time updates without manual intervention. Enhances user experience by presenting vital character information at a glance. |
| [reified_secondary_attribute.cljs](https://github.com/fmguerreiro/gurps-companion-app/blob/master/src/gurps/pages/character/widgets/reified_secondary_attribute.cljs) | Implements reified secondary attribute calculation and display for character widgets in the repositorys architecture. Uses point-per-cost mapping and calculates attribute value based on cost and dependency. Subscribe to attribute costs, values, and update on change.    |
| [attribute.cljs](https://github.com/fmguerreiro/gurps-companion-app/blob/master/src/gurps/pages/character/widgets/attribute.cljs)                                     | Defines and renders attribute input components for character pages, calculating attribute costs and updating values dynamically in the Gurps Companion app.                                                                                                                   |
| [helpers.cljs](https://github.com/fmguerreiro/gurps-companion-app/blob/master/src/gurps/pages/character/widgets/helpers.cljs)                                         | Implements attribute updates and keyword generation functions. Defines a mapping for attribute costs to points. Contributes to the character creation feature in the project.                                                                                                 |
| [base_text.cljs](https://github.com/fmguerreiro/gurps-companion-app/blob/master/src/gurps/pages/character/widgets/base_text.cljs)                                     | Implements dynamic text display and user input for GURPS character attributes, with cost calculations for updates.                                                                                                                                                            |
| [attributes.cljs](https://github.com/fmguerreiro/gurps-companion-app/blob/master/src/gurps/pages/character/widgets/attributes.cljs)                                   | Defines re-frame subs and events to manage character attributes and current values in the Gurps Companion App. Leverages reified attributes and secondary attributes for flexibility and modularity in the character creation process.                                        |
| [encumbrance_table.cljs](https://github.com/fmguerreiro/gurps-companion-app/blob/master/src/gurps/pages/character/widgets/encumbrance_table.cljs)                     | Implements encumbrance calculations for a character in the Gurps Companion App, highlighting weight classes. Subscriptions to attribute changes trigger updates in move and dodge columns, maintaining a responsive user interface for character management.                  |
| [summary_field.cljs](https://github.com/fmguerreiro/gurps-companion-app/blob/master/src/gurps/pages/character/widgets/summary_field.cljs)                             | Implements a summary field widget for character profiles, supporting editing and displaying data with localization, debouncing, and Re-frame state management.                                                                                                                |

</details>

<details closed><summary>src.gurps.widgets</summary>

| File                                                                                                                                          | Summary                                                                                                                                                                                                                                                                                    |
| ---                                                                                                                                           | ---                                                                                                                                                                                                                                                                                        |
| [dropdown.cljs](https://github.com/fmguerreiro/gurps-companion-app/blob/master/src/gurps/widgets/dropdown.cljs)                               | Implements a dropdown widget using React Native elements, Reagent, and Tailwind CSS for styling. Handles data options, placeholder, styling, and disabled state.                                                                                                                           |
| [bracketed_numeric_input.cljs](https://github.com/fmguerreiro/gurps-companion-app/blob/master/src/gurps/widgets/bracketed_numeric_input.cljs) | Implements bracketed numeric input widget for the Gurps Companion App, providing editable, numeric input with debouncing. Maintains visual consistency and flexibility within the apps UI components.                                                                                      |
| [underlined_input.cljs](https://github.com/fmguerreiro/gurps-companion-app/blob/master/src/gurps/widgets/underlined_input.cljs)               | Implements reusable UI components for input fields with underlined styling, offering single and multiline input options, including labeled variants. Each component allows customization such as text alignment and disabling input, enhancing user interactions within the app interface. |
| [base.cljs](https://github.com/fmguerreiro/gurps-companion-app/blob/master/src/gurps/widgets/base.cljs)                                       | Constructs React Native UI components and adapters for SectionList and FlatList for dynamic widget rendering in the Gurps Companion mobile app interface.                                                                                                                                  |
| [button.cljs](https://github.com/fmguerreiro/gurps-companion-app/blob/master/src/gurps/widgets/button.cljs)                                   | Defines customizable button component for React Native app, providing styling options and disabled functionality. Enhances user interaction with bold text, blue background, and customizations for disabled state. Essential for creating interactive UI elements.                        |

</details>

<details closed><summary>src.expo</summary>

| File                                                                                           | Summary                                                                                                                                                                 |
| ---                                                                                            | ---                                                                                                                                                                     |
| [root.cljs](https://github.com/fmguerreiro/gurps-companion-app/blob/master/src/expo/root.cljs) | Defines and renders the root component for Expo, managing component updates and lifecycle methods. Registers the root component with Expo for initializing the apps UI. |

</details>

<details closed><summary>src.react_native</summary>

| File                                                                                                                     | Summary                                                                                                                                                                                                                                                |
| ---                                                                                                                      | ---                                                                                                                                                                                                                                                    |
| [navigation.cljs](https://github.com/fmguerreiro/gurps-companion-app/blob/master/src/react_native/navigation.cljs)       | Implements navigation functionality for React Native using react-native-navigation and provides methods for setting roots, pushing, popping, showing modals, and registering listeners to handle navigation events.                                    |
| [async_storage.cljs](https://github.com/fmguerreiro/gurps-companion-app/blob/master/src/react_native/async_storage.cljs) | Implements async storage functions for React Native using Transit for data serialization and deserialization. Provides functions to set and get items as well as manage item storage. Handles error logging and debounces item setting for efficiency. |

</details>

---

##  Getting Started

**System Requirements:**

* **None**: `version x.y.z`

###  Installation

<h4>From <code>source</code></h4>

> 1. Clone the gurps-companion-app repository:
>
> ```console
> $ git clone https://github.com/fmguerreiro/gurps-companion-app
> ```
>
> 2. Change to the project directory:
> ```console
> $ cd gurps-companion-app
> ```
>
> 3. Install the dependencies:
> ```console
> $ > INSERT-INSTALL-COMMANDS
> ```

###  Usage

<h4>From <code>source</code></h4>

> Run gurps-companion-app using the command below:
> ```console
> $ > INSERT-RUN-COMMANDS
> ```

###  Tests

> Run the test suite using the command below:
> ```console
> $ > INSERT-TEST-COMMANDS
> ```

---

##  Project Roadmap

- [X] `► INSERT-TASK-1`
- [ ] `► INSERT-TASK-2`
- [ ] `► ...`

---

##  Contributing

Contributions are welcome! Here are several ways you can contribute:

- **[Report Issues](https://github.com/fmguerreiro/gurps-companion-app/issues)**: Submit bugs found or log feature requests for the `gurps-companion-app` project.
- **[Submit Pull Requests](https://github.com/fmguerreiro/gurps-companion-app/blob/main/CONTRIBUTING.md)**: Review open PRs, and submit your own PRs.
- **[Join the Discussions](https://github.com/fmguerreiro/gurps-companion-app/discussions)**: Share your insights, provide feedback, or ask questions.

<details closed>
<summary>Contributing Guidelines</summary>

1. **Fork the Repository**: Start by forking the project repository to your github account.
2. **Clone Locally**: Clone the forked repository to your local machine using a git client.
   ```sh
   git clone https://github.com/fmguerreiro/gurps-companion-app
   ```
3. **Create a New Branch**: Always work on a new branch, giving it a descriptive name.
   ```sh
   git checkout -b new-feature-x
   ```
4. **Make Your Changes**: Develop and test your changes locally.
5. **Commit Your Changes**: Commit with a clear message describing your updates.
   ```sh
   git commit -m 'Implemented new feature x.'
   ```
6. **Push to github**: Push the changes to your forked repository.
   ```sh
   git push origin new-feature-x
   ```
7. **Submit a Pull Request**: Create a PR against the original project repository. Clearly describe the changes and their motivations.
8. **Review**: Once your PR is reviewed and approved, it will be merged into the main branch. Congratulations on your contribution!
</details>

<details closed>
<summary>Contributor Graph</summary>
<br>
<p align="center">
   <a href="https://github.com{/fmguerreiro/gurps-companion-app/}graphs/contributors">
      <img src="https://contrib.rocks/image?repo=fmguerreiro/gurps-companion-app">
   </a>
</p>
</details>

---

##  License

This project is protected under the [SELECT-A-LICENSE](https://choosealicense.com/licenses) License. For more details, refer to the [LICENSE](https://choosealicense.com/licenses/) file.

---

##  Acknowledgments

- List any resources, contributors, inspiration, etc. here.

[**Return**](#-overview)

---
