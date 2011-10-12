(defn palindrome? [x]
    (let [s (.toString x)]
        (= (seq s)(reverse s))))

(defn palindrome-number [start end]
    (for [x (range start end) y (range x end) :when (palindrome? (* x y))] (* x y)))

(apply max (palindrome-number 100 1000))
