(defn fibo []
    (for [[x y] (iterate (fn [[x y]][y (+ x y)]) [1 2])] x))

(reduce + (filter even? (take-while (partial > 4000000) (fibo))))