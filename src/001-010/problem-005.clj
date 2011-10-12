(use '[clojure.contrib.lazy-seqs :only (primes)])

(defn primes? [x]
    ((complement not-any?) #(= x %)(take-while #(>= x %) primes)))

(defn every-divisible? [num divs]
    (every? #(zero? (rem num %)) divs))

(defn least-common-multiple [coll]
    (let [m (group-by primes? coll) ;;素数とそれ以外に分割
	  coll (map #(* (apply * (m true)) %)(iterate inc 1))] ;:取得した素数すべてを掛けた値に1倍、2倍、n倍としていく無限リスト
      (when-first [ret (filter #(every-divisible? % (m false)) coll)] ret)))

(least-common-multiple (range 1 21)) ;;1から20の最小公倍数
(least-common-multiple [1 7 9 13 22]) ;;1,7,9,13,22の最小公倍数