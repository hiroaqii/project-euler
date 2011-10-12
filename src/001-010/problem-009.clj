(defn hoge [n]
  (letfn [(check? [a b c] 
             (and (= n (+ a b c))
                  (= (+ (* a a)(* b b))(* c c))))]
  (let [x (/ n 2)]
    (first (for [a (range 1 x), b (range (inc a) x), c (range (inc b) x) :when (check? a b c)] [a b c])))))


(apply * (hoge 1000))