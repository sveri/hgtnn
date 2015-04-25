(ns de.sveri.hgtnn.playground)

(defn forward-multiply-gate [x y] (* x y))

(def x -2.0)
(def y 3.0)
(def tweak-amount 0.01)
(def best_out (atom Integer/MIN_VALUE))
(def best_x (atom x))
(def best_y (atom y))

(defn try-it [xy]
  (+ xy (* tweak-amount (- (* (Math/random) 2) 1))))

(defn rnd-local-search []
  (dotimes [k 100]
    (let [x_try (try-it x)
          y_try (try-it y)
          out (forward-multiply-gate (try-it x) (try-it y))]
      (when (< @best_out out)
        (reset! best_out out)
        (reset! best_y x_try)
        (reset! best_y y_try))))
  (println @best_out)
  (println @best_x)
  (println @best_y))