package FirstProject.MINI.repository;

import FirstProject.MINI.domain.Item;

import java.util.List;
import java.util.Optional;

public interface ItemRepository {

    Item save(Item item);
    //물건 등록
    void update(Long itemId, ItemUpdateDto updateParam);
    //ItemUpdateDto => 아이템 정보 변경에 필요한 데이터들
    
    Optional<Item> findById(Long id);
    //Id로 물건검색

    List<Item> findAll(ItemSearchCond cond);
    
}
