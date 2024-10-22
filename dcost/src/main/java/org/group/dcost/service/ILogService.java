package org.group.dcost.service;

import java.util.List;

public interface ILogService {
    List<Object> checkLog();
    List<Object> checkLogByDate(String date);
}
