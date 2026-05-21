def solution(clothes):
    from collections import Counter
    
    count = Counter(kind for _, kind in clothes)
    
    result = 1
    for cnt in count.values() :
        result *= (cnt + 1)
        
    return result - 1
