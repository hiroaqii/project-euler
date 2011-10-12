(use '[clojure.contrib.lazy-seqs :only (primes)])

(def triangle-nums (map #(quot (* % (+ % 1)) 2)(iterate inc 1)))

(defn factor [x]
  (if (= x 1)
    [1]
    (loop [ret [], x x, coll (take-while #(>= x %) primes)]
      (if (= x 1)
        ret
        (if (zero? (rem x (first coll)))
          (recur (conj ret (first coll))(quot x (first coll)) coll)
          (recur ret x (rest coll)))))))

(defn div-count [x]
  (if (= 1 x)
    1
    (reduce * (map #(+ (count %) 1)(vals (group-by identity (factor x)))))))

(defn problem-012 [n]
  (when-first [[k v] (filter (fn [[k v]] (< n v)) (map #(vector % (div-count %)) triangle-nums))] k))

(problem-012 500)
