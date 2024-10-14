from collections import deque

def solution(coin, cards):

    init_cards = set(cards[:len(cards)//3])
    left_cards = deque(cards[len(cards)//3:])
    drawed_cards = set()
    
    n = len(cards)
    coin = coin
    rounds = 1
    
    while len(left_cards) > 0:
        
        drawed_cards.add(left_cards.popleft())
        drawed_cards.add(left_cards.popleft())
        
        found = False
        for card in init_cards:
            pair = n + 1 - card
            if pair in init_cards and card != pair:
                init_cards.remove(card)
                init_cards.remove(pair)
                rounds += 1
                found = True
                break
        if found:
            continue
                
        if coin >= 1 and len(init_cards) > 0 and len(drawed_cards) > 0:
            for card in init_cards:
                pair = n + 1 - card
                if pair in drawed_cards:
                    init_cards.remove(card)
                    drawed_cards.remove(pair)
                    rounds += 1
                    coin -= 1
                    found = True
                    break
        if found:
            continue
                    
        if coin >= 2 and len(drawed_cards) >= 2:
            for card in drawed_cards:
                pair = n + 1 - card
                if pair in drawed_cards and card != pair:
                    drawed_cards.remove(card)
                    drawed_cards.remove(pair)
                    rounds += 1
                    coin -= 2
                    found = True
                    break
        if found:
            continue
            
        break # 더 이상 조합이 불가능한 경우
        
    return rounds
        
        
    
    