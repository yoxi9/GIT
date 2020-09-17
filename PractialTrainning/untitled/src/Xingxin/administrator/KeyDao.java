package Xingxin.administrator;

import java.util.List;

/**
 * @author Flobby
 */
public interface KeyDao {
    List<Key> getKey(Key key);

    int update(Key key);
}
