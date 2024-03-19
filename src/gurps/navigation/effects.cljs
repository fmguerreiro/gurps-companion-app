;; (ns gurps.navigation.effects
;;   (:require [re-frame.core :as rf]
;;             [react-native.navigation :as navigation]
;;             [gurps.navigation.options :as options]
;;             [gurps.navigation.roots :as roots]
;;             [gurps.navigation.state :as state]
;;             [gurps.navigation.view :as views]))

;; (rf/reg-fx :set-root
;;            (fn [root-id]
;;              (let [root (get (roots/roots) root-id)]
;;                ;; (dismiss-all-modals)
;;                ;; (rf/dispatch [:profile.settings/switch-theme
;;                ;;               (get roots/themes root-id)
;;                ;;               root-id])
;;                (reset! state/root-id (or (get-in root [:root :stack :id]) root-id))
;;                (navigation/set-root root))))

;; (defn- navigate
;;   [component]
;;   (let [{:keys [options]} (get views/screens component)]
;;     ;; (dismiss-all-modals)
;;     (navigation/push
;;      (name @state/root-id)
;;      {:component {:id      component
;;                   :name    component
;;                   :options (merge (options/root-options {:theme (:theme options)})
;;                                   options)}})))

;; (rf/reg-fx :navigate-to navigate)

;; (defn- navigate-to-within-stack
;;   [[component comp-id]]
;;   (let [{:keys [options]} (get views/screens component)]
;;     (navigation/push
;;      (name comp-id)
;;      {:component {:id      component
;;                   :name    component
;;                   :options (merge
;;                             (options/root-options {:theme (:theme options)})
;;                             options)}})))

;; (rf/reg-fx :navigate-to-within-stack navigate-to-within-stack)

;; (rf/reg-fx :navigate-replace-fx
;;            (fn [view-id]
;;              (navigation/pop (name @state/root-id))
;;              (navigate view-id)))

;; (defn dismiss-modal
;;   ([] (dismiss-modal nil))
;;   ([comp-id]
;;    (reset! state/dissmissing true)
;;    (navigation/dismiss-modal (name (or comp-id (last @state/modals))))))

;; (rf/reg-fx :navigate-back
;;            (fn []
;;              (if @state/curr-modal
;;                (dismiss-modal)
;;                (navigation/pop (name @state/root-id)))))

;; (rf/reg-fx :navigate-back-within-stack
;;            (fn [comp-id]
;;              (navigation/pop (name comp-id))))

;; (rf/reg-fx :navigate-back-to
;;            (fn [comp-id]
;;              (navigation/pop-to (name comp-id))))

;; (rf/reg-fx :dismiss-modal
;;            (fn [comp-id]
;;              (dismiss-modal (name comp-id))))

;; (defn- pop-to-root
;;   [root-id]
;;   (navigation/pop-to-root root-id)
;;   (dismiss-all-modals))

;; (rf/reg-fx :pop-to-root-fx pop-to-root)

;; ;; modal

;; (defn open-modal
;;   [component]
;;   (let [{:keys [options]} (get views/screens component)
;;         sheet?            (:sheet? options)]
;;     (if @state/dissmissing
;;       (reset! state/dissmissing component)
;;       (do
;;         (reset! state/curr-modal true)
;;         (swap! state/modals conj component)
;;         (navigation/show-modal
;;          {:stack {:children [{:component
;;                               {:name    component
;;                                :id      component
;;                                :options (merge (options/root-options {:theme (:theme options)})
;;                                                options
;;                                                (when sheet?
;;                                                  options/sheet-options))}}]}})))))

;; (rf/reg-fx :open-modal-fx open-modal)

;; ;; overlay

;; (defn show-overlay
;;   ([component] (show-overlay component {}))
;;   ([component opts]
;;    (navigation/dissmiss-overlay component)
;;    (navigation/show-overlay
;;     {:component {:name    component
;;                  :id      component
;;                  :options (merge (options/statusbar-and-navbar-options (:theme opts) nil nil)
;;                                  {:layout  {:componentBackgroundColor :transparent
;;                                             :orientation              ["portrait"]}
;;                                   :overlay {:interceptTouchOutside true}}
;;                                  opts)}})))

;; (rf/reg-fx :show-toasts
;;            (fn []
;;              (show-overlay "toasts"
;;                            {:overlay {:interceptTouchOutside false}
;;                             :layout  {:componentBackgroundColor :transparent
;;                                       :orientation              ["portrait"]}})))

;; (rf/reg-fx :hide-toasts
;;            (fn [] (navigation/dissmiss-overlay "toasts")))

;; ;;;; Bottom sheet

;; (rf/reg-fx :show-bottom-sheet
;;            (fn [] (show-overlay "bottom-sheet")))

;; (rf/reg-fx :hide-bottom-sheet
;;            (fn [] (navigation/dissmiss-overlay "bottom-sheet")))

;; ;;;; Alert Banner
;; (rf/reg-fx :show-alert-banner
;;            (fn [] (show-overlay "alert-banner" {:overlay {:interceptTouchOutside false}})))

;; (rf/reg-fx :hide-alert-banner
;;            (fn [] (navigation/dissmiss-overlay "alert-banner")))

;; ;;;; Merge options

;; (rf/reg-fx :merge-options
;;            (fn [{:keys [id options]}]
;;              (navigation/merge-options id options)))
