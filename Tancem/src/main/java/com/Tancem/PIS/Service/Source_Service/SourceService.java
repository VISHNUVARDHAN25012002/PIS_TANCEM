package com.Tancem.PIS.Service.Source_Service;

import com.Tancem.PIS.Model.Source.Source;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface SourceService {
    List<Source> getAllSources();
    Source getSourceById(Integer id);
    Source saveSource(Source source);
    void deleteSource(Integer id);
}
