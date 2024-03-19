; (ns gurps.navigation.view
;   (:require
;     ;; [quo.foundations.colors :as colors]
;     ;; [quo.theme :as theme]
;     [react-native.core :as rn]
;     [react-native.safe-area :as safe-area]
;     [reagent.core :as reagent]
;     schema.view
;     [gurps.common.alert-banner.view :as alert-banner]
;     [gurps.common.bottom-sheet-screen.view :as bottom-sheet-screen]
;     [gurps.common.bottom-sheet.view :as bottom-sheet]
;     [gurps.common.toasts.view :as toasts]
;     [gurps.navigation.screens :as screens]
;     [gurps.setup.hot-reload :as reloader]
;     [utils.re-frame :as rf]))

; (def functional-compiler (reagent/create-compiler {:function-components true}))

; (defn get-screens
;   []
;   (reduce
;    (fn [acc screen] (assoc acc (:name screen) screen))
;    {}
;    (screens/screens)))

; (def screens (get-screens))

; (defn screen
;   [screen-key]
;   (reagent.core/reactify-component
;    (fn []
;      (let [screen-details                (get (if js/goog.DEBUG
;                                                 (get-screens)
;                                                 screens)
;                                               (keyword screen-key))
;            qualified-screen-details      (get (if js/goog.DEBUG
;                                                 (get-screens)
;                                                 screens)
;                                               (keyword "screen" screen-key))
;            {:keys [component options]}   (or qualified-screen-details screen-details)
;            {:keys [insets sheet? theme]} options
;            user-theme                    (theme/get-theme)
;            alert-banners-top-margin      (rf/sub [:alert-banners/top-margin])
;            background-color              (or (get-in options [:layout :backgroundColor])
;                                              (when sheet? :transparent))]
;        ^{:key (str "root" screen-key @reloader/cnt)}
;         [theme/provider {:theme (or theme user-theme)}
;         [rn/view
;          {:style (wrapped-screen-style (assoc
;                                         insets
;                                         :background-color         background-color
;                                         :alert-banners-top-margin alert-banners-top-margin))}
;          [inactive]
;          (if sheet?
;            [bottom-sheet-screen/view {:content component}]
;            [component])]
;         (when js/goog.DEBUG
;           [:<>
;            [reloader/reload-view]
;            [schema.view/view]])]))
;    functional-compiler))

; (def bottom-sheet
;   (reagent/reactify-component
;    (fn []
;      (let [{:keys [sheets hide?]} (rf/sub [:bottom-sheet])
;            sheet                  (last sheets)
;            {:keys [theme]}        sheet
;            insets                 (safe-area/get-insets)
;            user-theme             (theme/get-theme)]
;        ^{:key (str "sheet" @reloader/cnt)}
;        [theme/provider {:theme (or theme user-theme)}
;         [inactive]
;         [rn/keyboard-avoiding-view
;          {:style                    {:position :relative :flex 1}
;           :keyboard-vertical-offset (- (max 20 (:bottom insets)))}
;          (when sheet
;            [bottom-sheet/view {:insets insets :hide? hide?}
;             sheet])]]))
;    functional-compiler))

; (def toasts (reagent/reactify-component toasts/toasts))

; (def alert-banner
;   (reagent/reactify-component
;    (fn []
;      ^{:key (str "alert-banner" @reloader/cnt)}
;      [theme/provider {:theme :dark}
;       [alert-banner/view]])
;    functional-compiler))
