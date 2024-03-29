INSERT INTO norm(name, description)
VALUES
    ('NOM-001-STPS-2008', 'EDIFICIOS, LOCALES, INSTALACIONES Y ÁREAS EN LOS CENTROS DE TRABAJO - CONDICIONES DE SEGURIDAD'),
    ('NOM-002-STPS-2010','CONDICIONES DE SEGURIDAD - PREVENCIÓN Y PROTECCIÓN CONTRA INCENDIOS EN LOS CENTROS DE TRABAJO'),
    ('NOM-004-STPS-1999','SISTEMAS DE PROTECCIÓN Y DISPOSITIVOS DE SEGURIDAD EN LA MAQUINARIA Y EQUIPO QUE SE UTILICE EN LOS CENTROS DE TRABAJO'),
    ('NOM-005-STPS-1998 ','RELATIVA A LAS CONDICIONES DE SEGURIDAD E HIGIENE EN LOS CENTROS DE TRABAJO PARA EL MANEJO, TRANSPORTE Y ALMACENAMIENTO DE SUSTANCIAS QUÍMICAS PELIGROSAS'),
    ('NOM-006-STPS-2014','MANEJO Y ALMACENAMIENTO DE MATERIALES-CONDICIONES DE SEGURIDAD Y SALUD EN EL TRABAJO.'),
    ('NOM-015-STPS-2001','CONDICIONES TÉRMICAS ELEVADAS O ABATIDAS - CONDICIONES DE SEGURIDAD E HIGIENE'),
    ('NOM-017-STPS-2008','EQUIPO DE PROTECCIÓN PERSONAL - SELECCIÓN, USO Y MANEJO EN LOS CENTROS DE TRABAJO'),
    ('NOM-018-STPS-2015','SISTEMA ARMONIZADO PARA LA IDENTIFICACIÓN Y COMUNICACIÓN DE PELIGROS Y RIESGOS POR SUSTANCIAS QUÍMICAS PELIGROSAS EN LOS CENTROS DE TRABAJO.'),
    ('NOM-019-STPS-2011','CONSTITUCIÓN, INTEGRACIÓN, ORGANIZACIÓN Y FUNCIONAMIENTO DE LAS COMISIONES DE SEGURIDAD E HIGIENE'),
    ('NOM-020-STPS-2011','RECIPIENTES SUJETOS A PRESIÓN, RECIPIENTES CRIOGÉNICOS Y GENERADORES DE VAPOR O CALDERAS - FUNCIONAMIENTO - CONDICIONES DE SEGURIDAD.'),
    ('NOM-027-STPS-2008','ACTIVIDADES DE SOLDADURA Y CORTE - CONDICIONES DE SEGURIDAD E HIGIENE'),
    ('NOM-030-STPS-2009','SERVICIOS PREVENTIVOS DE SEGURIDAD Y SALUD EN EL TRABAJO - FUNCIONES Y ACTIVIDADES'),
    ('NOM-033-STPS-2015','CONDICIONES DE SEGURIDAD PARA REALIZAR TRABAJOS EN ESPACIOS CONFINADOS'),
    ('NOM-034-STPS-2016','CONDICIONES DE SEGURIDAD PARA EL ACCESO Y DESARROLLO DE ACTIVIDADES DE TRABAJADORES CON DISCAPACIDAD EN LOS CENTROS DE TRABAJO'),
    ('NOM-035-STPS-2018','ACTORES DE RIESGO PSICOSOCIAL EN EL TRABAJO-IDENTIFICACIÓN, ANÁLISIS Y PREVENCIÓN');

INSERT INTO requirement(requirement, foundation, norm_id)
VALUES ('CNSS-MI-UCA-001-3.- Registros de los resultados de las verificaciones oculares en bitácoras, medios magnéticos o en las actas de verificación de la Comisión de Seguridad e Higiene.', 'Artículos 132 fracciones I, XVI y XVII y 512-D de la Ley Federal del Trabajo; 7 fracción VII, XV y XXII  y 17 fracción I y 18, fracción XIV del Reglamento Federal de Seguridad y Salud en el Trabajo publicado en el Diario Oficial de la Federación el  13 de noviembre de 2014; y punto 5.2 de la NOM-001-STPS-2008, Edificios, locales, instalaciones y áreas en los centros de trabajo - Condiciones de seguridad, publicada en el Diario Oficial de la Federación el 24 de noviembre de 2008.',1),
    ('CNSS-RG-VOO-001 (12)-4.- Registros de resultados de las verificaciones oculares realizadas posteriormente a la ocurrencia de un evento que pudiera generarle daños al centro de trabajo. ','132 fracciones I y XVII y 512-D de la Ley Federal del Trabajo; 7 fracciones VII, XV y XXII, 17 fracción I y 18 fracción XIV del Reglamento Federal de Seguridad y Salud en el Trabajo publicado en el Diario Oficial de la Federación el  13 de noviembre de 2014; y punto 5.3 de la NOM-001-STPS-2008, Edificios, locales, instalaciones y áreas en los centros de trabajo - Condiciones de seguridad, publicada en el Diario Oficial de la Federación el 24 de noviembre de 2008.',1),
    ('CNSS-RG-VOE-001-5.- Registros anuales en bitácoras de los resultados de la ejecución del programa de mantenimiento preventivo o correctivo del sistema de ventilación artificial.','Artículos 132 fracciones I y XVII, y 512-D de la Ley Federal del Trabajo; 7 fracciones VII,XV y XXII, 17 fracción I y 18 fracción XIV del Reglamento Federal de Seguridad y Salud en el Trabajo publicado en el Diario Oficial de la Federación el 13 de noviembre de 2014; y punto 8.3 de la NOM-001-STPS-2008, Edificios, locales, instalaciones y áreas en los centros de trabajo - Condiciones de seguridad, publicada en el Diario Oficial de la Federación el 24 de noviembre de 2008',1);

INSERT INTO rol(name)
VALUES ('administrador'),
       ('supervisor'),
       ('cliente');

INSERT INTO usercessca(name,surname,email,password,rol_id) VALUES
                                                              ('Jesus','Noriega','jesus@gmail.com','cessca123',1),
                                                              ('Yamilet','Noriega','yamilet@gmail.com','cessca123',1);

INSERT INTO customer(rfc,denomination,address,password,usercessca_id) VALUES
                                                                          ('123212','Sociedad Anónima de Capital Variable (S.A. de C.V.)','Av.Insurgentes #199 CDMX','variable123',1),
                                                                          ('7453947','Pinturas Comex (S.A. de C.V.)','Av.Reforma #99 CDMX','variable123',2);