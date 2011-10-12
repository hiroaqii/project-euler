(defn next-collatz-num [n]
  (if (even? n)
    (quot n 2)
    (inc (* n 3))))

(defn collatz [n]
  (take-while #(< 1 %)(iterate next-collatz-num n)))

(defn max-count-collatz [n]
  (when (> n 0)      
    (first 
      (reduce 
        #(if (> (last %1)(last %2)) %1 %2) 
          [1 1] (map #(list % (count (collatz %))) (range 1 (inc n)))))))

(max-count-collatz 999999)