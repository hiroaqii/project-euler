;;http://projecteuler.net/index.php?section=problems&id=1

(defn hoge [x coll]
  (filter (fn [num](some #(zero? (rem num %)) coll))(range x)))

;;1000未満の３か５の倍数の合計
(reduce + (hoge 1000 [3 5]))

;;1000未満の4か7か13の倍数の合計
(reduce + (hoge 1000 [4 7 13]))
