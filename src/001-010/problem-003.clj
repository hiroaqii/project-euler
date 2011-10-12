(use '[clojure.contrib.lazy-seqs :only (primes)])

(defn max-prime-factor [x]
    (last (filter #(zero? (rem x %)) (take-while #(>= (Math/sqrt x) %) primes))))

(max-prime-factor 600851475143)
