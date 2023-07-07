package jpabook.jpashop.repository;


import jakarta.persistence.EntityManager;
import jpabook.jpashop.domain.item.Item;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@RequiredArgsConstructor
public class ItemRepository {

    private final EntityManager em;

    public void save(Item item){
        if(item.getId() == null){
            em.persist(item);
            //만일 id값이 없는경우? -> 완전히 새로 생성한 객체라는 의미이므로 persist.
        }else{
            em.merge(item);
            //있는경우? -> 이미 DB에 있는 객체이므로 merge == update .
        }
    }

    public Item findOne(Long id){
        return em.find(Item.class,id);
    }

    public List<Item> findAll(){
        return em.createQuery("select i from Item i", Item.class)
                .getResultList();
    }

    public void change(Item item,ItemDTO itemDTO){
        item.setName(itemDTO.getName);
    }
}
