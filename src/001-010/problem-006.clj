(defn hoge [x]
    (- (Math/pow (reduce + (range 1 (inc x))) 2 )
       (reduce + (map #(Math/pow % 2)(range 1 (inc x))))))

(int (hoge 100))