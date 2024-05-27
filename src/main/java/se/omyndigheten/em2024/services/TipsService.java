package se.omyndigheten.em2024.services;

import org.springframework.stereotype.Service;
import se.omyndigheten.em2024.domain.Matchen;

import java.util.Map;

/**
 * Created by Krille on 27/05/2024 22:34
 */
public interface TipsService {

    public Map<Long,Matchen> getAllMatches();
}
