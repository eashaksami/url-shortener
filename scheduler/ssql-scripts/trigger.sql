CREATE OR REPLACE FUNCTION update_url_row_status_function()
RETURNS TRIGGER AS $$
BEGIN
    DELETE FROM url WHERE id=1;
    RETURN NEW;
END;
$$ LANGUAGE plpgsql;

CREATE TRIGGER update_url_row_status_function
    AFTER UPDATE ON scheduler_job
    EXECUTE PROCEDURE update_url_row_status_function();

-- created < NOW() - INTERVAL '1 year'