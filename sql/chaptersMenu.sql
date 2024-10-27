-- 菜单 SQL
insert into sys_menu (menu_name, parent_id, order_num, path, component, is_frame, is_cache, menu_type, visible, status, perms, icon, create_by, create_time, update_by, update_time, remark)
values('course_chapters', '0', '1', 'chapters', 'course/chapters/index', 1, 0, 'C', '0', '0', 'course:chapters:list', '#', 'admin', sysdate(), '', null, 'course_chapters菜单');

-- 按钮父菜单ID
SELECT @parentId := LAST_INSERT_ID();

-- 按钮 SQL
insert into sys_menu (menu_name, parent_id, order_num, path, component, is_frame, is_cache, menu_type, visible, status, perms, icon, create_by, create_time, update_by, update_time, remark)
values('course_chapters查询', @parentId, '1',  '#', '', 1, 0, 'F', '0', '0', 'course:chapters:query',        '#', 'admin', sysdate(), '', null, '');

insert into sys_menu (menu_name, parent_id, order_num, path, component, is_frame, is_cache, menu_type, visible, status, perms, icon, create_by, create_time, update_by, update_time, remark)
values('course_chapters新增', @parentId, '2',  '#', '', 1, 0, 'F', '0', '0', 'course:chapters:add',          '#', 'admin', sysdate(), '', null, '');

insert into sys_menu (menu_name, parent_id, order_num, path, component, is_frame, is_cache, menu_type, visible, status, perms, icon, create_by, create_time, update_by, update_time, remark)
values('course_chapters修改', @parentId, '3',  '#', '', 1, 0, 'F', '0', '0', 'course:chapters:edit',         '#', 'admin', sysdate(), '', null, '');

insert into sys_menu (menu_name, parent_id, order_num, path, component, is_frame, is_cache, menu_type, visible, status, perms, icon, create_by, create_time, update_by, update_time, remark)
values('course_chapters删除', @parentId, '4',  '#', '', 1, 0, 'F', '0', '0', 'course:chapters:remove',       '#', 'admin', sysdate(), '', null, '');

insert into sys_menu (menu_name, parent_id, order_num, path, component, is_frame, is_cache, menu_type, visible, status, perms, icon, create_by, create_time, update_by, update_time, remark)
values('course_chapters导出', @parentId, '5',  '#', '', 1, 0, 'F', '0', '0', 'course:chapters:export',       '#', 'admin', sysdate(), '', null, '');