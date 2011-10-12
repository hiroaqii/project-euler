(defn route-count [width height]
  (when (and (pos? width)(pos? height))
    (/ (apply *' (range (inc width)(inc (+ width height))))
       (apply *' (range 1 (inc height))))))

(route-count 20 20)