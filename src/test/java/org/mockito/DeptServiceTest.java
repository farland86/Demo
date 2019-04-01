package org.mockito;

import org.domain.dto.DeptDto;
import org.domain.service.impl.DeptServiceImpl;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.junit.MockitoJUnitRunner;

/**
 * Created by root on 3/22/19.
 */

@RunWith(MockitoJUnitRunner.class)
public class DeptServiceTest {

    private DeptDto dto;
    @Mock
    DeptServiceImpl ds;

    @Before
    public void setUp() throws Exception {
        dto = new DeptDto();
        dto.setDeptName("dept1");
    }

    @Test
    public void testSave()  {
        ds.save(dto);
    }

    @Test
    public void testUpdate()  {
        ds.update(dto);
    }

    @Test
    public void testDelete()  {
        ds.delete(1);
    }

}
