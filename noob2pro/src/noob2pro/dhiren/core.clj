(ns noob2pro.dhiren.core)


(defn b
  "calculate fibonacci series upto a terms"
  [a]
  (reverse (reduce (fn [c d]
                     (conj c (+ (first c) (second c)))) '(1 1)
                     (range 1 (- a 1)))))
(defn fib
"fibnocci series summation of terms less than 4000000"
  [n]
  (reduce +
          (filter even?
                  (filter #(< % 4000000 )
                          (b n)))))
(defn prime?
"Checks is prime or not"
  [a]
  (= 0 (count (filter
               #(and (= 0 (mod % 1)) (= 0 (mod a %)))
               (range 2 (inc (/ a 2)))))))



(defn prob6 [n]
  (let [sum (reduce  +  (range 1 (inc n)))
        s-sum (reduce +
                      (map #(* % %) (range 1 (inc n))))]
    (- (* sum sum ) s-sum)))

(defn gcd
"calculates the gcd of two numbers"
  [a b]
  (if (zero? b)
    a
    (gcd b (rem a b))))


(defn lcm
"calculates lcm of two numbers"
  [a b]
  (/ (* a b) (gcd a b)))

(defn prob5 [n]
  (reduce lcm (range 1 (inc n))))






;;(filter palindrome? (range 10000 998001))

;;(filter #(and (= 0 (mod % 1)) (= 0 (mod a %))) (range 2 a)) ;;factors finding
#_(defn prob4 []
    (map (fn [a] (filter #(and (= 0 (mod % 1)) (= 0 (mod a %))) (range 100 999))) (filter palindrome? (range 10000 998001)))
  )



(defn prime-numbers
"last prime number upto n"
  [n]
  (last (take n (filter prime? (range)))))


(defn palindrome?
  "to check if number is palindrome or not"
  [n]
  (= (str n) (clojure.string/reverse (str n))))

(defn l-palindrome
  "calculates the largest palindrome"
  []
  (apply max
          (filter palindrome?
                  (for [x (range 100 1000)
                        y (range 100 1000)]
                    (* x y)))))
#_(def given-number 73167176531330624919225119674426574742355349194934969835203127745063262395783180169848018694788518438586156078911294949545950173795833195285320880551112540698747158523863050715693290963295227443043557668966489504452445231617318564030987111217223831136222989342338030813533627661428280644448664523874930358907296290491560440772390713810515859307960866701724271218839987979087922749219016997208880937766572733300105336788122023542180975125454059475224352584907711670556013604839586446706324415722155397536978179778461740649551492908625693219784686224828397224137565705605749026140797296865241453510047482166370484403199890008895243450658541227588666881164271714799244429282308634656748139191231628245861786645835912456652947654568284891288314260769004224219022671055626321111109370544217506941658960408071984038509624554443629812309878799272442849091888458015616609791913387 499200524063689912560717606058861164671094050775410022569831552000559357297257163626956188267042825248360082325753042075296345)





(defn triplet
  "problem 9 of project euler"
  [x]
  (first (for [a (range 1 (/ x 2))
               b (range (inc a ) (/ x 2))
               :let [c (- x a b)]
               :when (= (* c c) (+ (* a a) (* b b)))]
           (* a b c))))

(def a
7316717653133062491922511967442657474235534919493496983520312774506326239578318016984801869478851843858615607891129494954595017379583319528532088055111254069874715852386305071569329096329522744304355766896648950445244523161731856403098711121722383113622298934233803081353362766142828064444866452387493035890729629049156044077239071381051585930796086670172427121883998797908792274921901699720888093776657273330010533678812202354218097512545405947522435258490771167055601360483958644670632441572215539753697817977846174064955149290862569321978468622482839722413756570560574902614079729686524145351004748216637048440319989000889524345065854122758866688116427171479924442928230863465674813919123162824586178664583591245665294765456828489128831426076900422421902267105562632111110937054421750694165896040807198403850962455444362981230987879927244284909188845801561660979191338754992005240636899125607176060588611646710940507754100225698315520005593572972571636269561882670428252483600823257530420752963450)

(defn split-digits
"for getting each number"
  [number]
  (map #(Character/digit % 10) (str number)))

(defn listt
  "generates a list of all combinations of product of 13 adjacent numbers"
  [coll out]
  (if (empty? coll)
    out
    (listt (rest coll)
           (cons (reduce * (take 13 coll)) out))))
(def prob8-ans
  (apply max (listt (split-digits a) [])))

(defn sum-prime
  "generates prime number below range and adds it"
  [m]
  (reduce +  (filter prime? (range 2 m))))

(defn traingular
  "calculates  triangular numbers"
  []
  (map #(reduce +
                (range (inc %)))
       (range )))

(defn divisors
  [o]
  (count (filter #(= 0 (mod o %))
                 (range 1 (inc  o)))))

(defn count-factors [x]
  (count (filter #(= 0 (mod x %))
                 (range 1 (inc  x)))))

(defn prob12
  [n]
  (last (take-while #(<= (count-factors %) n)
                    (traingular))))

(def grid [[8 2 22 97 38 15 0 40 0 75 4 5 7 78 52 12 50 77 91 8]
           [49 49 99 40 17 81 18 57 60 87 17 40 98 43 69 48 4 56 62 0]
           [81 49 31 73 55 79 14 29 93 71 40 67 53 88 30 3 49 13 36 65]
           [52 70 95 23 4 60 11 42 69 24 68 56 1 32 56 71 37 2 36 91]
           [22 31 16 71 51 67 63 89 41 92 36 54 22 40 40 28 66 33 13 80]
           [24 47 32 60 99 3 45 2 44 75 33 53 78 36 84 20 35 17 12 50]
           [32 98 81 28 64 23 67 10 26 38 40 67 59 54 70 66 18 38 64 70]
           [67 26 20 68 2 62 12 20 95 63 94 39 63 8 40 91 66 49 94 21]
           [24 55 58 5 66 73 99 26 97 17 78 78 96 83 14 88 34 89 63 72]
           [21 36 23 9 75 0 76 44 20 45 35 14 0 61 33 97 34 31 33 95]
           [78 17 53 28 22 75 31 67 15 94 3 80 4 62 16 14 9 53 56 92]
           [16 39 5 42 96 35 31 47 55 58 88 24 0 17 54 24 36 29 85 57]
           [86 56 0 48 35 71 89 7 5 44 44 37 44 60 21 58 51 54 17 58]
           [19 80 81 68 05 94 47 69 28 73 92 13 86 52 17 77 4 89 55 40]
           [4 52 8 83 97 35 99 16 7 97 57 32 16 26 26 79 33 27 98 66]
           [88 36 68 87 57 62 20 72 3 46 33 67 46 55 12 32 63 93 53 69]
           [4 42 16 73 38 25 39 11 24 94 72 18 8 46 29 32 40 62 76 36]
           [20 69 36 41 72 30 23 88 34 62 99 69 82 67 59 85 74 4 36 16]
           [20 73 35 29 78 31 90 1 74 31 49 71 48 86 81 16 23 57 5 54]
           [1 70 54 71 83 51 54 69 16 92 33 48 61 43 52 1 89 19 67 48]
           ])


(defn down-product
  [grid x y]
  (let [a (get-in grid [x y] 1)
        b (get-in grid [(inc x) y] 1)
        c (get-in grid [(+ 2 x) y] 1)
        d (get-in grid [(+ 3 x) y] 1)]
    (* a b c d)))

(defn right-product
  [grid x y]
  (let [a (get-in grid [x y] 1)
        b (get-in grid [x (inc y)] 1)
        c (get-in grid [x (+ 2 y)] 1)
        d (get-in grid [x (+ 3 y)] 1)]
    (* a b c d)))

(defn leftd-product
  [grid x y]
  (let [a (get-in grid [x y] 1)
        b (get-in grid [(inc x) (dec y)] 1)
        c (get-in grid [(+ x 2) (- y 2)] 1)
        d (get-in grid [(+ x 3) (- y 3)] 1)]
    (* a b c d)))

(defn rightd-product
  [grid x y]
  (let [a (get-in grid [x y] 1)
        b (get-in grid [(inc x) (inc y)] 1)
        c (get-in grid [(+ x 2) (+ y 2)] 1)
        d (get-in grid [(+ x 3) (+ y 3)] 1)]
    (* a b c d)))


(defn prob11
  [grid]
  (apply max (for [x (range 20)
                    y (range 20)]
                (apply max [(down-product grid x y) (right-product grid x y) (leftd-product grid x y) (rightd-product grid x y)]))))



;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;
;;;Codechef problems

(defn ATM
  "take input from file and then processes it"
  [fname]
  (let [x (slurp (str "resources/" fname))
        y (clojure.string/split x #" ")
        a (read-string (first y))
        b (read-string (second y))]
    (if (and  (= 0 (mod a 5)) (> b a) (not= b a))
      (- b a 0.50)
      b
      )))



(defn Input
  "for processing input"
  [fname]
  (let [x (slurp (str "resources/" fname))
        y (clojure.string/split x #"[\s]")]
    (map #(Integer/parseInt %) y)))


(defn InputTest
  "Problem on codechef  https://www.codechef.com/problems/INTEST"
  [fname]
  (let [x (Input fname)
        y (second x)
        z (drop 2 x)]
    (count (filter #(= 0 (mod % y)) z))))


;;;;;;;;;;;4 CLOJURE PROBLEMS;;;;;
                                        ;
(defn nilkey [key map]
  (if (contains? map key)
    (nil? (key map))
    false
    ))

(fn maps [key vector1]
  (zipmap vector1 (into [] (repeat (count vector1) key)) ) )

(defn ad [vector1]
  (apply concat (map #(repeat 2 %) vector1)))

(fn  [a b]
  (loop[a a
        ret []]
    (if(= a b)
      (seq ret)
      (recur (inc a) (concat ret [a])))))


#_(defn unique
  [a]
  (if (string? a)
    (distinct a)


))
