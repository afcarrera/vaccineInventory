INSERT INTO dose(dose_id, dose_description) VALUES ('1', 'Primera Dosis');
INSERT INTO dose(dose_id, dose_description) VALUES ('2', 'Segunda Dosis');
INSERT INTO dose(dose_id, dose_description) VALUES ('3', 'Dosis Refuerzo');

INSERT INTO option(opti_id, opti_name) VALUES ('REMP', 'REGISTRAR EMPLEADO');
INSERT INTO option(opti_id, opti_name) VALUES ('AEMP', 'ACTUALIZAR EMPLEADO');
INSERT INTO option(opti_id, opti_name) VALUES ('ADSEMP', 'ACTUALIZAR DATOS SENSIBLES EMPLEADO');
INSERT INTO option(opti_id, opti_name) VALUES ('LEMP', 'LISTAR EMPLEADO');
INSERT INTO option(opti_id, opti_name) VALUES ('LEMPPI', 'LISTAR EMPLEADO POR ID');
INSERT INTO option(opti_id, opti_name) VALUES ('EEMP', 'ELIMINAR EMPLEADO');
INSERT INTO option(opti_id, opti_name) VALUES ('FPEDV', 'FILTRAR POR ESTADO DE VACUNACIÓN');
INSERT INTO option(opti_id, opti_name) VALUES ('FPTDV', 'FILTRAR POR TIPO DE VACUNA');
INSERT INTO option(opti_id, opti_name) VALUES ('FPRDFDV', 'FILTRAR POR RANGO DE FECHA DE VACUNACION');

INSERT INTO phone_type(phty_id, phty_name) VALUES ('CON', 'Convencional');
INSERT INTO phone_type(phty_id, phty_name) VALUES ('CEL', 'Celular');

INSERT INTO role(role_id, role_description) VALUES ('ADM', 'ADMINISTRADOR');
INSERT INTO role(role_id, role_description) VALUES ('EMP', 'EMPLEADO');

INSERT INTO role_option(role_id, opti_id) VALUES ('ADM', 'REMP');
INSERT INTO role_option(role_id, opti_id) VALUES ('ADM', 'AEMP');
INSERT INTO role_option(role_id, opti_id) VALUES ('ADM', 'ADSEMP');
INSERT INTO role_option(role_id, opti_id) VALUES ('ADM', 'LEMP');
INSERT INTO role_option(role_id, opti_id) VALUES ('ADM', 'LEMPPI');
INSERT INTO role_option(role_id, opti_id) VALUES ('ADM', 'EEMP');
INSERT INTO role_option(role_id, opti_id) VALUES ('ADM', 'FPEDV');
INSERT INTO role_option(role_id, opti_id) VALUES ('ADM', 'FPTDV');
INSERT INTO role_option(role_id, opti_id) VALUES ('ADM', 'FPRDFDV');
INSERT INTO role_option(role_id, opti_id) VALUES ('EMP', 'AEMP');
INSERT INTO role_option(role_id, opti_id) VALUES ('EMP', 'LEMPPI');

INSERT INTO vaccination_status(vast_id, vast_status) VALUES ('V', 'Vacunado');
INSERT INTO vaccination_status(vast_id, vast_status) VALUES ('N', 'No Vacunado');

INSERT INTO vaccine(vaty_id, vaty_name) VALUES ('S', 'Sputnik');
INSERT INTO vaccine(vaty_id, vaty_name) VALUES ('AZ', 'AstraZeneca');
INSERT INTO vaccine(vaty_id, vaty_name) VALUES ('P', 'Pfizer');
INSERT INTO vaccine(vaty_id, vaty_name) VALUES ('JJ', ' Jhonson&Jhonson');

INSERT INTO vaccine_dose(vacc_dose_id, dose_id, vaty_id) VALUES ('1S', '1', 'S');
INSERT INTO vaccine_dose(vacc_dose_id, dose_id, vaty_id) VALUES ('2S', '2', 'S');
INSERT INTO vaccine_dose(vacc_dose_id, dose_id, vaty_id) VALUES ('1AZ', '1', 'AZ');
INSERT INTO vaccine_dose(vacc_dose_id, dose_id, vaty_id) VALUES ('2AZ', '2', 'AZ');
INSERT INTO vaccine_dose(vacc_dose_id, dose_id, vaty_id) VALUES ('3AZ', '3', 'AZ');
INSERT INTO vaccine_dose(vacc_dose_id, dose_id, vaty_id) VALUES ('1P', '1', 'P');
INSERT INTO vaccine_dose(vacc_dose_id, dose_id, vaty_id) VALUES ('2P', '2', 'P');
INSERT INTO vaccine_dose(vacc_dose_id, dose_id, vaty_id) VALUES ('3P', '3', 'P');
INSERT INTO vaccine_dose(vacc_dose_id, dose_id, vaty_id) VALUES ('1JJ', '1', 'JJ');
INSERT INTO vaccine_dose(vacc_dose_id, dose_id, vaty_id) VALUES ('2JJ', '2', 'JJ');

INSERT INTO end_user(role_id, user_name, user_password, user_modification_date, user_login_count)
VALUES ('ADM', 'kruger', '8d969eef6ecad3c29a3a629280e686cf0c3f5d5a86aff3ca12020c923adc6c92', '2022-05-01', 0);
