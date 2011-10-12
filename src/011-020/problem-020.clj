(defn char-to-num [c]
  (Character/getNumericValue c))

(reduce + (map char-to-num (seq (str (reduce *' (range 1 101))))))