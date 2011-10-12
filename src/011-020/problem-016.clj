(defn char-to-int [c]
  (Character/getNumericValue c))

(defn pow [x y]
  (reduce *' (repeat y x)))

(reduce + (map char-to-int (str (pow 2 1000))))