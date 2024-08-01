package com.Tancem.PIS.ServiceImpl.Source_Service_Impl;

import com.Tancem.PIS.DAO.Source_Repository.SourceRepository;
import com.Tancem.PIS.Exceptions.CustomException;
import com.Tancem.PIS.Model.Source.Source;
import com.Tancem.PIS.Service.Source_Service.SourceService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class SourceServiceImpl implements SourceService {
    private static final Logger logger = LoggerFactory.getLogger(SourceServiceImpl.class);

    @Autowired
    private SourceRepository sourceRepository;

    @Override
    public List<Source> getAllSources() {
        List<Source> sources = sourceRepository.findAll();
        logger.info("Retrieved all sources");
        return sources;
    }

    @Override
    public Source getSourceById(Integer id) {
        Optional<Source> source = sourceRepository.findById(id);
        if (source.isPresent()) {
            logger.info("Retrieved source with id: {}", id);
            return source.get();
        } else {
            logger.error("Source not found with id: {}", id);
            throw new CustomException("Source not found");
        }
    }

    @Override
    public Source saveSource(Source source) {
        Source savedSource = sourceRepository.save(source);
        logger.info("Saved source with id: {}", savedSource.getId());
        return savedSource;
    }

    @Override
    public void deleteSource(Integer id) {
        sourceRepository.deleteById(id);
        logger.info("Deleted source with id: {}", id);
    }
}
