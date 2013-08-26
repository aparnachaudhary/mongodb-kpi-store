package net.arunoday.kpi.engine.service.impl;

import net.arunoday.kpi.engine.repository.GaugeEventRepository;
import net.arunoday.kpi.engine.repository.GaugeMetricRepository;
import net.arunoday.kpi.engine.service.MetricAggregationService;

import org.joda.time.DateTime;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

/**
 * Default implementation of {@link MetricAggregationService}
 * 
 * @author Aparna Chaudhary
 * 
 */
@Service
public class MetricAggregationServiceImpl implements MetricAggregationService {

	@Autowired
	private GaugeEventRepository<String> gaugeEventRepository;
	@Autowired
	private GaugeMetricRepository<String> gaugeMetricRepository;

	@Override
	@Scheduled(cron = "0 0/1 * * * ?")
	public void performAggregationPerMinute() {
		DateTime startDate = new DateTime();
		for (String eventType : gaugeEventRepository.findEventTypes()) {
			gaugeEventRepository.aggregatePerMinute(eventType, startDate.minusSeconds(60).toDate(), startDate.toDate());
		}
	}

	@Override
	@Scheduled(cron = "0 0 0 * * ?")
	public void performAggregationPerHour() {
		DateTime startDate = new DateTime();
		for (String eventType : gaugeEventRepository.findEventTypes()) {
			gaugeEventRepository.aggregatePerHour(eventType, startDate.minusMinutes(60).toDate(), startDate.toDate());
		}
	}

	@Override
	@Scheduled(cron = "0 0 0 0 * ?")
	public void performAggregationPerDay() {
		DateTime startDate = new DateTime();
		for (String eventType : gaugeEventRepository.findEventTypes()) {
			gaugeEventRepository.aggregatePerHour(eventType, startDate.minusHours(24).toDate(), startDate.toDate());
		}
	}
}
