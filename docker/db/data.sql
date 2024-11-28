# -----------------------
INSERT INTO TASK (task_id,name,description) VALUES
(1,'Parent task1','Placeholder for parent task'),
(2,'Subtask1',''),
(3,'Subtask2',''),
(4,'Subtask21',''),
(5,'Subtask32','');

INSERT INTO TASK_DEPENDENCY (dependency_id, task_id, depends_on_task_id, dependencyType, createdAt) VALUES
(1, 2, 1, 'PARENT', '2024-11-16 12:00:01'),
(2, 3, 1, 'PARENT', '2024-11-16 12:00:02'),
(3, 4, 3, 'PARENT', '2024-11-16 12:00:03'),
(4, 5, 4, 'PARENT', '2024-11-16 12:00:04');