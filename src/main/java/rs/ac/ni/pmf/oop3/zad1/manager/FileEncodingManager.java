package rs.ac.ni.pmf.oop3.zad1.manager;

import java.io.*;
import java.util.List;
import lombok.extern.slf4j.Slf4j;
import rs.ac.ni.pmf.oop3.zad1.*;

@Slf4j
public class FileEncodingManager extends EncodingManager
{
	public FileEncodingManager(final Encoder encoder, final List<PasswordValidator> passwordValidators)
	{
		super(encoder, passwordValidators);
	}

	@Override
	protected byte[] getDataAsBytes(final String dataLocation) throws EncodingManagerException
	{
		try (final InputStream inputStream = new BufferedInputStream(new FileInputStream(dataLocation)))
		{
			return inputStream.readAllBytes();
		}
		catch (final FileNotFoundException e)
		{
			log.info("Failed to load data from: {}. Trying to load it from the resources", dataLocation);

			final InputStream resourceInputStream = FileEncodingManager.class.getResourceAsStream(dataLocation);

			if (resourceInputStream == null)
			{
				log.error("Failed to load data from {}", dataLocation);
				throw new BadFileException();
			}

			try (resourceInputStream)
			{
				return resourceInputStream.readAllBytes();
			}
			catch (IOException ex)
			{
				log.error(e.getMessage());
				throw new BadFileException();
			}
		}
		catch (final IOException e)
		{
			log.error(e.getMessage());
			throw new BadFileException();
		}
	}
}
